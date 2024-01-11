package org.hcneed.server.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI().info(new Info() //
                .title("HC Need API Documents") //
                .description("HC Need API Documents") //
                .version("0.0.1"));
    }

}
