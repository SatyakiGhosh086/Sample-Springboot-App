package com.practice.SampleSpringBootApplication.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class MyInterceptorConFig extends WebMvcConfigurerAdapter
{
	   @Autowired
	   MyLoggerInterceptor myLoggerInterceptor;

	   @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(myLoggerInterceptor);
	   }
}
