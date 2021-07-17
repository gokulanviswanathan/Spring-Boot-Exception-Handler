package com.practice.customexception.interceptor;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CustomAuthInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LogManager.getLogger(CustomAuthInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String trackingId = "";
		trackingId = (String) request.getAttribute("trackingId");
		if (StringUtils.isEmpty(trackingId)) {
			LOGGER.error("TrackingId found to be empty in the request");
			trackingId = UUID.randomUUID().toString();
			request.setAttribute("trackingId", trackingId);
			LOGGER.error("New trackingId has been set in the request:: {}", trackingId);
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		//DO NOTHING
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		ThreadContext.clearAll();

	}

}
