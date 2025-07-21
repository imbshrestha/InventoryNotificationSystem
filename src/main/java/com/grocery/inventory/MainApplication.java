package com.grocery.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot entry point.
 * It scans for @Component, @Service, @Configuration, and @RestController.
 */
@SpringBootApplication(scanBasePackages = "com.grocery.inventory")
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}

/*
package com.grocery.inventory;

import com.grocery.inventory.config.AppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MainApplication extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { AppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
*/

/*
    // 🟡 Original MainApplication.java (console-based Spring Core app)
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
*/
