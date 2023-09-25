package com.example.demo_springmvc_resttemplate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateBuilderConfig {

    @Value("${base.url.jsonPlaceHolder}")
    private String rootUrl;

    @Bean
    RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer) {
        RestTemplateBuilder builder = configurer.configure(new RestTemplateBuilder());

        DefaultUriBuilderFactory uriBuilderFactory =
                new DefaultUriBuilderFactory(rootUrl);

        RestTemplateBuilder configuredBuilder = builder.uriTemplateHandler(uriBuilderFactory);

        return configuredBuilder;
    }
}
