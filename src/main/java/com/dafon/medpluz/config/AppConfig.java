package com.dafon.medpluz.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {
    @Bean
    public Dotenv dotenv() {
        return Dotenv.configure()
                .load();
    }
}
