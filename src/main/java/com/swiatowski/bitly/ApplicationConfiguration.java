package com.swiatowski.bitly;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by Piotrek on 8/24/2015.
 */
@Configuration
public class ApplicationConfiguration extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/web/*")
                .addResourceLocations("/web/")
                .setCachePeriod(0);
    }

}