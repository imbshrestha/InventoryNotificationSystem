package com.grocery.inventory.config;

import com.grocery.inventory.lifecycle.AppLifecycleLogger;
import com.grocery.inventory.service.InventoryService;
import com.grocery.inventory.service.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.grocery.inventory")
public class AppConfig {
    @Bean
    public AppLifecycleLogger lifecycleLogger() {
        return new AppLifecycleLogger();
    }

    @Bean
    public NotificationService notificationService() {
        return new NotificationService();
    }

    @Bean
    public InventoryService inventoryService(NotificationService notificationService) {
        return new InventoryService(notificationService);
    }
}
