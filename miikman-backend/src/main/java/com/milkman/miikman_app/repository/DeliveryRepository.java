package com.milkman.miikman_app.repository;
import com.milkman.miikman_app.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    List<Delivery> findByDate(LocalDate date);
    
}