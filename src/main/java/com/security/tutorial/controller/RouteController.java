package com.security.tutorial.controller;


import com.security.tutorial.entity.Customer;
import com.security.tutorial.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class RouteController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String home(){
        return "Home Page";
    }

    @PostMapping("/new")
    public String newCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
        return "User saved";
    }
}
