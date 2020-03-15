package com.caching.filter;

import java.io.Serializable;
import java.util.HashMap;

public class CachedResponse implements Serializable {

	private String contentType;
	private String body;
	private HashMap<String, String> headers;
	private HashMap<String, String> zuulHeaders;

	public CachedResponse(String contentType, String body, HashMap<String, String> headers, HashMap<String, String> zuulHeaders) {
		this.contentType = contentType;
		this.body = body;
		this.headers = headers;
		this.zuulHeaders = zuulHeaders;
	}

	public String getContentType() {
		return contentType;
	}

	public HashMap<String, String> getHeaders() {
		return headers;
	}

	public String getBody() {
		return body;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setHeaders(HashMap<String, String> headers) {
		this.headers = headers;
	}

	public HashMap<String, String> getZuulHeaders() {
		return zuulHeaders;
	}

	public void setZuulHeaders(HashMap<String, String> zuulHeaders) {
		this.zuulHeaders = zuulHeaders;
	}

}
