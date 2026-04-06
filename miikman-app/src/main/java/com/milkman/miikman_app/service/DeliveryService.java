package com.milkman.miikman_app.service;
import com.milkman.miikman_app.model.Customer; 
import com.milkman.miikman_app.model.Delivery;
import com.milkman.miikman_app.repository.CustomerRepository;
import com.milkman.miikman_app.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryService {

    private final CustomerRepository customerRepo;
    private final DeliveryRepository deliveryRepo;

    public DeliveryService(CustomerRepository customerRepo, DeliveryRepository deliveryRepo) {
        this.customerRepo = customerRepo;
        this.deliveryRepo = deliveryRepo;
    }

    // 🔥 MAIN LOGIC
    public List<Delivery> generateTodayDeliveries() {

        LocalDate today = LocalDate.now();

        // check if already generated
        List<Delivery> existing = deliveryRepo.findByDate(today);
        if (!existing.isEmpty()) {
            return existing;
        }

        List<Customer> customers = customerRepo.findAll();
        List<Delivery> deliveries = new ArrayList<>();

        for (Customer c : customers) {

            // ✅ LOGIC: who gets milk today
            if (isDeliveryDay(c, today)) {

                Delivery d = new Delivery();
                d.setCustomerId(c.getId());
                d.setDate(today);
                d.setQuantity(c.getQuantity());
                d.setStatus("PENDING");

                deliveries.add(d);
            }
        }

        return deliveryRepo.saveAll(deliveries);
    }

    // 🧠 RULE ENGINE
    private boolean isDeliveryDay(Customer c, LocalDate date) {

        if (c.getSubscriptionType().equalsIgnoreCase("daily")) {
            return true;
        }

        if (c.getSubscriptionType().equalsIgnoreCase("alternate")) {
            return date.getDayOfMonth() % 2 == 0; // even days
        }

        return false;
    }

    // get today's deliveries
    public List<Delivery> getTodayDeliveries() {
        return deliveryRepo.findByDate(LocalDate.now());
    }

    // mark delivered
    public Delivery markDelivered(Long id) {
        Delivery d = deliveryRepo.findById(id).orElseThrow();
        d.setStatus("DELIVERED");
        return deliveryRepo.save(d);
    }
}