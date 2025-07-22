package com.grocery.inventory.controller;


import com.grocery.inventory.service.InventoryService;
import com.grocery.inventory.controller.InventoryController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class InventoryControllerTest {

    @Test
    void testCheckInventoryEndpoint() {
        InventoryService mockService = Mockito.mock(InventoryService.class);
        InventoryController controller = new InventoryController(mockService);

        Mockito.when(mockService.checkInventoryAPI("Lentils", 10))
                .thenReturn("✅ In Stock: 10/20 available.");


        ResponseEntity<String> response = controller.checkInventory("Lentils", 10);

        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertEquals("✅ In Stock: 10/20 available.", response.getBody());

        Mockito.verify(mockService, Mockito.times(1)).checkInventoryAPI("Lentils", 10);
    }
}
