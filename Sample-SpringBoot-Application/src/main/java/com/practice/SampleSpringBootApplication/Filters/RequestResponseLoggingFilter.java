package com.practice.SampleSpringBootApplication.Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RequestResponseLoggingFilter implements Filter 
{
	Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		logger.info("In RequestResponse Logging Filter");
		logger.info("Method : "+httpRequest.getMethod());
		logger.info("Request Path URL : "+httpRequest.getMethod());
		logger.info("Response : "+httpResponse.getContentType());
		
		chain.doFilter(request, response);
		
	}
	
	@Bean
	public FilterRegistrationBean<RequestResponseLoggingFilter> registertingFilter()
	{
		FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	        
	    registrationBean.setFilter(new RequestResponseLoggingFilter());
	    registrationBean.addUrlPatterns("/test/*"); //which urls should this filter intercept 
	    registrationBean.setOrder(2);
	        
	    return registrationBean;
	}

}
