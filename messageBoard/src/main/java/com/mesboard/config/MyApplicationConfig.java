package com.mesboard.config;

import com.mesboard.intercepor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfigurer:等同于SpringMVC配置文件
 */
@Configuration
public class MyApplicationConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器到容器  InterceptorRegistry保存拦截器对象
        String addPath [] = { "/*"}; //拦截user开始的所有请求
        String exludePath [] = {"/","/index","/registryIndex","/user/registry"}; //不拦截
        registry.addInterceptor( new MyInterceptor() )
                .addPathPatterns(addPath) //拦截的地址，可以是多个
                .excludePathPatterns(exludePath); //不拦截的地址，可以是多个

    }
}
