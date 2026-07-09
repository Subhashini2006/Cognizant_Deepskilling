package com.cognizant.apigateway.filter;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class LogFilter implements Filter {

    private static final Logger LOGGER =
            Logger.getLogger(LogFilter.class.getName());

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        LOGGER.info("Request Path: " + httpRequest.getRequestURI());

        chain.doFilter(request, response);
    }
}