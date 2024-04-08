package com.practice.SampleSpringBootApplication.Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyLoggerInterceptor implements HandlerInterceptor
{
	private static Logger log = LoggerFactory.getLogger(MyLoggerInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 
	{
		System.out.println("Executing Pre Handler method");
		log.info("[preHandle][" + request + "]" + "[" + request.getMethod()
	      + "]" + request.getRequestURI() + request.getPathInfo());
	    
	    return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception 
	{
		System.out.println("In the post handle method");
		log.info("[postHandle][" + request + "]");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception 
	{
		System.out.println("In the after completion method");
		if (ex != null){
	        ex.printStackTrace();
	    }
	    log.info("[afterCompletion][" + request + "][exception: " + ex + "]");
	}
}
