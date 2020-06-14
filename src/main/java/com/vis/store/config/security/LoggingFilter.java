package com.vis.store.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@Component
@Slf4j
public class LoggingFilter extends GenericFilterBean {

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
                         final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        final String url = httpServletRequest.getRequestURL()
                .toString();
        final String queryString = Optional.ofNullable(httpServletRequest.getQueryString())
                .map(value -> "?" + value)
                .orElse("");
        log.info(String.format("applying LssLoggingFilter for URI: %s%s", url, queryString));

        filterChain.doFilter(servletRequest, servletResponse);
    }
}