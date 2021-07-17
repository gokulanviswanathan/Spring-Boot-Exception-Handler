/**
 * 
 */
package com.practice.customexception.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfiguration implements WebMvcConfigurer {

	@Autowired
	private CustomAuthInterceptor customAuthInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(customAuthInterceptor);
	}

}
