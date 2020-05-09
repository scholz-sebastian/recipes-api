//package de.seblz.recipes.api.configuration;
//
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Data
//@Configuration
//@ConfigurationProperties(prefix = "recipe")
//public class SecurityConfig implements WebMvcConfigurer {
//
//    private final Security security;
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping(security.apiMatcher)
//            .allowedOrigins(security.getCors().getAllowedOrigins())
//            .allowedMethods(security.getCors().getAllowedMethods())
//            .allowedHeaders(security.getCors().getAllowedHeaders())
//            .exposedHeaders(security.getCors().getExposedHeaders())
//            .allowCredentials(security.getCors().getAllowCredentials())
//            .maxAge(security.cors.getMaxAge());
//    }
//
//    @Data
//    public static class Security {
//        private String apiMatcher;
//        private Cors cors;
//    }
//
//    @Data
//    public static class Cors {
//        private String[] allowedOrigins;
//        private String[] allowedMethods;
//        private String[] allowedHeaders;
//        private String[] exposedHeaders;
//        private Boolean allowCredentials;
//        private Long maxAge;
//    }
//
//}
