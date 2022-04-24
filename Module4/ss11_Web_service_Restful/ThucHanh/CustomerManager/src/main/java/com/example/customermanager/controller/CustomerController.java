package com.example.customermanager.controller;

import com.example.customermanager.model.Customer;
import com.example.customermanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<Customer>> findAllCustomer() {
        List<Customer> customers = customerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    // Get
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Integer id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    // Add
    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }


    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        Customer temp = customerService.findById(id);
        if (temp == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        customer.setId(id);
        customerService.save(customer);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(customer, HttpStatus.NO_CONTENT);
    }
}
