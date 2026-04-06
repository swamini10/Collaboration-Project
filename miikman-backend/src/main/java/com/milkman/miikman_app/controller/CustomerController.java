package com.milkman.miikman_app.controller;

import com.milkman.miikman_app.model.Customer;
import com.milkman.miikman_app.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // ✅ Add Customer
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return service.addCustomer(customer);
    }

    // ✅ Get All Customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }
}