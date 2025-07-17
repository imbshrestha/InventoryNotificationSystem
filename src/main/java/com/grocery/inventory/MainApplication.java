package com.grocery.inventory;

import config.AppConfig;
import service.InventoryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        InventoryService inventoryService = context.getBean(InventoryService.class);

        inventoryService.checkInventory("Basmati Rice", 8);
        inventoryService.checkInventory("Lentils", 25);

        context.close(); // Triggers @PreDestroy
    }
}
