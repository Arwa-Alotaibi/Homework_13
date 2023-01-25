package com.example.banksystem.Pogo;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customers {
    private String id ;
    private String username;
    private double balance;

    private double amount = 500;
}
