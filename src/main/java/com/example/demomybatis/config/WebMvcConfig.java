package com.example.demomybatis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        if(!registry.hasMappingForPattern("/templates/**")){
            registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
        }
        super.addResourceHandlers(registry);

        if(!registry.hasMappingForPattern("/resources/**")){
            registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
        }
        super.addResourceHandlers(registry);

        if(!registry.hasMappingForPattern("/static/**")){
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        }
        super.addResourceHandlers(registry);

    }
}
