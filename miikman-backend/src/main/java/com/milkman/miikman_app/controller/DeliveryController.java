package com.milkman.miikman_app.controller;

import com.milkman.miikman_app.model.Delivery;
import com.milkman.miikman_app.service.DeliveryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
@CrossOrigin
public class DeliveryController {

    private final DeliveryService service;

    public DeliveryController(DeliveryService service) {
        this.service = service;
    }

    // 🔥 Generate today's list
    @GetMapping("/today")
    public List<Delivery> generateToday() {
        return service.generateTodayDeliveries();
    }

    // get today's deliveries
    @GetMapping
    public List<Delivery> getToday() {
        return service.getTodayDeliveries();
    }

    // mark delivered
    @PutMapping("/{id}")
    public Delivery markDelivered(@PathVariable Long id) {
        return service.markDelivered(id);
    }
}