package com.example.todoapp.api.middlewares;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Filter request configurations
 */
@Configuration
public class FilterConfig {

    /**
     * Set request filter configuration
     * @return
     */
    @Bean
    public FilterRegistrationBean<RequestFilter> validationFilter() {
        FilterRegistrationBean<RequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestFilter());
        registrationBean.addUrlPatterns("/api/*"); // Apply filter only to specific URL patterns
        registrationBean.setOrder(1); // Order of execution if you have multiple filters
        return registrationBean;
    }
}
