package io.github.orionlibs.uns_app;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.github.orionlibs.core.registry.ModuleRegistrar;
import io.github.orionlibs.utilities.UtilitiesSpringConfiguration;
import java.util.TimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableWebMvc
@EnableScheduling
@ComponentScan(basePackages = {"io.github.orionlibs.api"})
@Import({SpringConfiguration.class,
                UtilitiesSpringConfiguration.class})
public class SpringBootApplication extends SpringBootServletInitializer implements WebMvcConfigurer
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootApplication.class, args);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }


    @Bean
    public HandlerMapping handlerMapping()
    {
        return new RequestMappingHandlerMapping();
    }


    @Bean
    public HandlerAdapter handlerAdapter()
    {
        return new RequestMappingHandlerAdapter();
    }


    @Bean
    public ObjectMapper getObjectMapper()
    {
        return new Jackson2ObjectMapperBuilder().serializationInclusion(Include.NON_NULL)
                        .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                                        SerializationFeature.FAIL_ON_EMPTY_BEANS,
                                        SerializationFeature.FAIL_ON_SELF_REFERENCES)
                        .build()
                        .setDefaultPrettyPrinter(new MinimalPrettyPrinter());
    }


    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "HEAD", "OPTIONS", "websocket", "ws")
                        .allowedHeaders("*");
    }


    @Bean
    public ModuleRegistrar moduleRegistrar(ApplicationContext applicationContext)
    {
        ModuleRegistrar moduleRegistrar = new ModuleRegistrar(applicationContext);
        moduleRegistrar.registerModules();
        return moduleRegistrar;
    }
}
