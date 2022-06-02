package com.prueba.prueba.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewProductDTO { 
    @NotNull(message = "Name not valid or null")
    private String name;
    @NotNull(message = "Price invalid, please insert again ")
    private double price;
    @NotNull(message = "Weight can't be null.")
    private double weight;
    private String expirationDate;
    @Max(message = "out of stock",value = 20)
    private String stock;
}
