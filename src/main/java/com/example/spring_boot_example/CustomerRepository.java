package com.example.spring_boot_example;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository <Customer,Integer>{
    Customer findCustomersById(Integer id);
}
