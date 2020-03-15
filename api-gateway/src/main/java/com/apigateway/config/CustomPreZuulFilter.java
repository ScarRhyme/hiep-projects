package com.apigateway.config;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class CustomPreZuulFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String OAUTH_TOKEN_SERVICE_REGEX = "^/[a-z0-9._-]+/oauth/token$";

    @Override
    public Object run() {
        final RequestContext ctx = RequestContext.getCurrentContext();
        logger.info("in zuul filter " + ctx.getRequest().getRequestURI());
        byte[] encoded;
        try {
            encoded = Base64.encode("utt-client:$2a$04$e/c1/RfsWuThaWFCrcCuJeoyvwCV0URN/6Pn9ZFlrtIWaU/vj/BfG".getBytes("UTF-8"));
            ctx.addZuulRequestHeader("Authorization", "Basic " + new String(encoded));
            ctx.addZuulRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");

            logger.info("pre filter");
            logger.info(ctx.getRequest().getHeader("Authorization"));

            final HttpServletRequest req = ctx.getRequest();

            final String refreshToken = extractRefreshToken(req);
            if (refreshToken != null) {
                final Map<String, String[]> param = new HashMap<String, String[]>();
                param.put("refresh_token", new String[] {refreshToken});
                param.put("grant_type", new String[] {"refresh_token"});

                ctx.setRequest(new CustomHttpServletRequest(req, param));
            }

        } catch (final UnsupportedEncodingException e) {
            logger.error("Error occured in pre filter", e);
        }

        //

        return null;
    }

    private String extractRefreshToken(HttpServletRequest req) {
        final Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equalsIgnoreCase("refreshToken")) {
                    return cookies[i].getValue();
                }
            }
        }
        return null;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String proxy = ctx.getRequest().getRequestURI();
        return proxy.matches(OAUTH_TOKEN_SERVICE_REGEX);
    }

    @Override
    public int filterOrder() {
        return 1000;
    }

    @Override
    public String filterType() {
        return "pre";
    }

}