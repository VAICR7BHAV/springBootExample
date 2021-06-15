package com.example.spring_boot_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/add")
    public String addCustomer(@RequestParam String first, @RequestParam String last){
        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customerRepository.save(customer);
        return "Added new customer to repository";
    }

    @GetMapping("/list")
    public Iterable<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/test")
    public String displayTestMessage()
    {
        return "This is a test maessage";
    }

    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id)
    {
        return customerRepository.findCustomersById(id);
    }
}
