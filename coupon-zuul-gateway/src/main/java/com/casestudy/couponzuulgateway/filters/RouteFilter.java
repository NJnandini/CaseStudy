package com.casestudy.couponzuulgateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

@Configuration
public class RouteFilter extends ZuulFilter {
	
	private static Logger log = LoggerFactory.getLogger(RouteFilter.class);

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		log.info("Inside route filter..");
		return null;
	}

	@Override
	public String filterType() {
		
		return "Route";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}
	
	
}
