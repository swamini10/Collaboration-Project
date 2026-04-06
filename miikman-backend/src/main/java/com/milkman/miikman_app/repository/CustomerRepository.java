package com.milkman.miikman_app.repository;
import com.milkman.miikman_app.model.Delivery;
import com.milkman.miikman_app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}