package config;

import lifecycle.AppLifecycleLogger;
import service.InventoryService;
import service.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
