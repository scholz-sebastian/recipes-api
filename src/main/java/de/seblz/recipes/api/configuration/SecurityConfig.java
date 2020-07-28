package de.seblz.recipes.api.configuration;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Data
@Configuration
@ConfigurationProperties(prefix = "security")
public class SecurityConfig implements WebMvcConfigurer {

    private Cors cors;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins(cors.getAllowedOrigins())
            .allowedMethods(cors.getAllowedMethods())
            .allowedHeaders(cors.getAllowedHeaders())
            .exposedHeaders(cors.getExposedHeaders())
            .allowCredentials(cors.getAllowCredentials())
            .maxAge(cors.getMaxAge());
    }

    @Data
    public static class Cors {
        private String[] allowedOrigins;
        private String[] allowedMethods;
        private String[] allowedHeaders;
        private String[] exposedHeaders;
        private Boolean allowCredentials;
        private Long maxAge;
    }

}
