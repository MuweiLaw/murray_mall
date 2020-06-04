package com.murray.mallclientserver.config;

import com.murray.mallclientserver.interceptor.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration  //适配器
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    @Bean
    public UserInterceptor getUserInterceptor() {
        return new UserInterceptor();
    }

    @Override
    /**
     *@Param [registry]
     *@return void
     *@Description: //TODO 25627
     *@author Murray Law
     *@date 2019/10/28 15:25
     */
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(getUserInterceptor()).excludePathPatterns()
                .addPathPatterns("/**")                    //拦截所有请求
                .excludePathPatterns("/user/login");    //对应的不拦截的请求
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**")                    //拦截所有请求
                .addResourceLocations("classpath:/static/");    //对应的不拦截的请求
        super.addResourceHandlers(registry);
    }
}
