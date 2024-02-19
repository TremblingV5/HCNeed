package org.hcneed.server.config;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import org.hcneed.server.exceptions.user.TokenInvalid;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
public class SaTokenConfig extends WebMVCConfig {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor(handle -> {
            try {
                StpUtil.checkLogin();
            } catch (NotLoginException e) {
                throw new TokenInvalid();
            }
        }))
        .addPathPatterns("/api/**")
        .excludePathPatterns(
                "/**/swagger-ui/index.html",
                "/**/api-docs/**",
                "/**/swagger-resources",
                "/**/webjars/**",
                "/**/favicon.ico"
        );
    }
}
