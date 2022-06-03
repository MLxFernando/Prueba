package com.prueba.prueba.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TBL_PRODUCTS")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;
    @Column(name = "PRICE", precision = 4, scale = 2)
    private double price;
    @Column(name = "WEIGHT", precision = 4, scale = 2)
    private double weight;
    @Column(name = "EXPIRATION_DATE")
    private String expirationDate;
    @Column(name = "STOCK")
    private String stock;
}
