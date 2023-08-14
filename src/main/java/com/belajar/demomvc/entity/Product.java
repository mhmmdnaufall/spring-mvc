package com.belajar.demomvc.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
        length = 10,
        nullable = false,
        unique = true
    )
    private String code;

    @Column(
        length = 150,
        nullable = false
    )
    private String name;

    private double price;

}
