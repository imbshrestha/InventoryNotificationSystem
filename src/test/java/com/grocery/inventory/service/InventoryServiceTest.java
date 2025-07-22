package com.grocery.inventory.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InventoryServiceTest {

    private InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        NotificationService mockNotificationService = mock(NotificationService.class);
        inventoryService = new InventoryService(mockNotificationService);
        inventoryService.initializeInventory(); // Make sure this method exists
    }

    @Test
    void checkItemNotFound() {
        String result = inventoryService.checkInventoryAPI("Dragon Fruit", 5);
        assertEquals("❌ Item 'Dragon Fruit' not found in inventory.", result);
    }

    @Test
    void checkItemNotEnoughStock() {
        String result = inventoryService.checkInventoryAPI("Basmati Rice", 15);
        assertEquals("❌ Not enough stock for Basmati Rice. Only 10 left.", result);
    }

    @Test
    void checkItemAvailable() {
        String result = inventoryService.checkInventoryAPI("Lentils", 10);
        assertEquals("✅ Lentils inventory is sufficient.", result);
    }

}
