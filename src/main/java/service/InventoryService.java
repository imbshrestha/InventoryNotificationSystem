package service;

public class InventoryService {
    private final NotificationService notificationService;

    public InventoryService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void checkInventory(String item, int quantity) {
        if (quantity < 10) {
            notificationService.sendLowStockAlert(item, quantity);
        } else {
            System.out.println(item + " inventory is sufficient.");
        }
    }
}
