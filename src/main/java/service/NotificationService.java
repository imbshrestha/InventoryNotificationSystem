package service;

public class NotificationService {
    public void sendLowStockAlert(String item, int quantity) {
        System.out.println("ALERT: Low stock for " + item + ". Only " + quantity + " left!");
    }
}
