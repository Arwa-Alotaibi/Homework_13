package com.example.banksystem.controller;


import com.example.banksystem.Pogo.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/")
public class BankController {

    ArrayList<Customers> customerss = new ArrayList<Customers>();


    //Get all the customers
    @GetMapping("/get")
    public ArrayList<Customers> getall(@RequestBody Customers customer){
        return customerss;
    }
    //Add new customers
    @PostMapping("/add")
    public String addcustomer(@RequestBody Customers customer){
        customerss.add(customer);
        return "the customer added successfully :)";
    }

    //Update customers
    @PutMapping("/update/{index}")
    public String update(@PathVariable int index ,@RequestBody Customers customer){
        customerss.set(index,customer);
        return "the customer updated successfully :)";
    }


    //Delete customers
    @DeleteMapping("/delete/{index}")
    public String deletecustomer(@PathVariable int index ){
        customerss.remove(index);
        return "the customer deleted successfully :)";
    }
    //Deposit money to customer
    @PutMapping("/deposit/{index}")
    public String deposit(@PathVariable int index , @RequestBody Customers customer){
        double amount =customer.getAmount();
        customer.setBalance(customer.getBalance()+amount);
        customerss.set(index,customer);
        return "The amount has been deposited successfully";
    }
    //Withdraw money from customers
    @PutMapping("/withdraw/{index}")
    public String withdraw(@PathVariable int index , @RequestBody Customers customer){
        if(customer.getAmount()> customer.getBalance()){
            return "Insufficient";
        }
        else {
            double amount =customer.getAmount();
            customer.setBalance(customer.getBalance()-amount);
            customerss.set(index,customer);
            return "The amount has been withdrawn successfully ";
        }

    }

}
