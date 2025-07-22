package com.grocery.inventory.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@Service
public class InventoryService {
    private final NotificationService notificationService;
    private Map<String, Integer> inventory = new HashMap<>();

    public InventoryService(NotificationService notificationService) {
        this.notificationService = notificationService;
        initializeInventory();
    }

    public void initializeInventory() {
        inventory.put("Basmati Rice", 10);
        inventory.put("Lentils", 20);
    }

    public String checkInventoryAPI(String item, int quantity) {
        if (!inventory.containsKey(item)) {
            return "❌ Item '" + item + "' not found in inventory.";
        }

        int stock = inventory.get(item);

        if (stock < quantity) {
            return "❌ Not enough stock for " + item + ". Only " + stock + " left.";
        } else {
            return "✅ " + item + " inventory is sufficient.";
        }
    }

    public void checkInventory(String item, int quantity) {
        if (!inventory.containsKey(item)) {
            System.out.println("Item not found in inventory.");
            return;
        }

        int stock = inventory.get(item);

        if (stock < quantity) {
            notificationService.sendLowStockAlert(item, stock);
        } else {
            System.out.println(item + " inventory is sufficient.");
        }
    }

    // For unit test access
    public Map<String, Integer> getInventory() {
        return inventory;
    }
}