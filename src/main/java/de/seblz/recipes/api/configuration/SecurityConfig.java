package de.seblz.recipes.api.configuration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "recipe")
@EnableAsync
public class SecurityConfig implements WebMvcConfigurer {

    private Security security;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(security.apiMatcher)
            .allowedOrigins(security.cors.getAllowedOrigins())
            .allowedMethods(security.cors.getAllowedMethods())
            .allowedHeaders(security.cors.getAllowedHeaders())
            .exposedHeaders(security.cors.getExposedHeaders())
            .allowCredentials(security.cors.getAllowCredentials())
            .maxAge(security.cors.getMaxAge());
    }

    public CorsConfiguration getCorsConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(security.cors.getAllowedOrigins());
        corsConfiguration.setAllowedMethods(security.cors.getAllowedMethods());
        corsConfiguration.setAllowedHeaders(security.cors.getAllowedHeaders());
        corsConfiguration.setExposedHeaders(security.cors.getExposedHeaders());
        corsConfiguration.setAllowCredentials(security.cors.getAllowCredentials());
        corsConfiguration.setMaxAge(security.cors.getMaxAge());
        return corsConfiguration;
    }

    @Data
    public static class Security {
        private String apiMatcher;
        private Cors cors;
    }

    @Data
    public static class Cors {
        private List<String> allowedOrigins;
        private List<String> allowedMethods;
        private List<String> allowedHeaders;
        private List<String> exposedHeaders;
        private Boolean allowCredentials;
        private Long maxAge;
    }

}
