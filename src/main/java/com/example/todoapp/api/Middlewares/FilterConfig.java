package com.example.todoapp.api.Middlewares;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<RequestFilter> validationFilter() {
        FilterRegistrationBean<RequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestFilter());
        registrationBean.addUrlPatterns("/api/*"); // Apply filter only to specific URL patterns
        registrationBean.setOrder(1); // Order of execution if you have multiple filters
        return registrationBean;
    }
}
