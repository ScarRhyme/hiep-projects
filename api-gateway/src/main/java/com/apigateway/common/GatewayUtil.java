package com.apigateway.common;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;

@Component("gatewayUtil")
public class GatewayUtil {

    @Autowired
    private LoadBalancerClient loadBalancer;

    private final Logger LOGGER = LoggerFactory.getLogger(GatewayUtil.class);

    public URI getServiceUrl(String serviceId, String fallbackUri) {
        URI uri = null;
        try {
            ServiceInstance instance = loadBalancer.choose(serviceId);
            uri = instance.getUri();
            LOGGER.info("Resolved serviceId '{}' to URL '{}'." + serviceId + "  " + uri);
        } catch (RuntimeException e) {
            // Eureka not available, use fallback
            uri = URI.create(fallbackUri);
            LOGGER.info("Failed to resolve serviceId '{}'. Fallback to URL '{}'." + serviceId + " " + uri);
        }
        return uri;
    }
}
