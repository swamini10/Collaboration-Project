package com.milkman.miikman_app.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data   // ✅ IMPORTANT
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String phone;
    private String milkType;
    private int quantity;
    private String subscriptionType;
}
