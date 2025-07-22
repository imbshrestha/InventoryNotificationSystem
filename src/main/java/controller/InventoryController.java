package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.grocery.inventory.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/inventory")
    public ResponseEntity<String> checkInventory(@RequestParam String item, @RequestParam int quantity) {
        String result = inventoryService.checkInventoryAPI(item, quantity);
        return ResponseEntity.ok(result); // ✅ Returns ResponseEntity<String>
    }



}