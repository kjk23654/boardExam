package com.portfolio.configs.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 사이트 설정 유지
 *
 */

@Component
public class SiteConfigInterceptor implements HandlerInterceptor {
    // 사이트 설정을 공통으로 처리할 수 있는 부분을 담당

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setAttribute("cssJsVersion", 1);

        return true;
    }
}
