package com.practice.SampleSpringBootApplication.Filters;

import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class TransactionalFilter implements Filter
{
	public static Logger logger = LoggerFactory.getLogger(TransactionalFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		logger.info("In Transactional Filter");
		logger.info("Method : "+httpRequest.getMethod());
		logger.info("Request Path URL : "+httpRequest.getMethod());
		logger.info("Response : "+httpResponse.getContentType());
		
		chain.doFilter(request, response);
		
		
	}

}
