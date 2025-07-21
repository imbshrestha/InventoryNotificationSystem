package com.grocery.inventory.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
public class InventoryService {
    private final NotificationService notificationService;

    public InventoryService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    public String checkInventoryAPI(String item, int quantity) {
        if (quantity < 10) {
            return "ALERT: Low stock for " + item + ". Only " + quantity + " left!";
        } else {
            return item + " inventory is sufficient.";
        }
    }


    public void checkInventory(String item, int quantity) {
        if (quantity < 10) {
            notificationService.sendLowStockAlert(item, quantity);
        } else {
            System.out.println(item + " inventory is sufficient.");
        }
    }

}
