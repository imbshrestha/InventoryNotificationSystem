package com.grocery.inventory.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class AppLifecycleLogger {
    @PostConstruct
    public void init() {
        System.out.println("Application has started. Bean is initialized.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Application is stopping. Bean is being destroyed.");
    }
}
