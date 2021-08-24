package com.clody2code.msscbeerservice001.web.controller;


import com.clody2code.msscbeerservice001.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {


    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId")UUID customerId){
        return new ResponseEntity(CustomerDto.builder().id(UUID.randomUUID()).name("Vanga Moussa").build(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody CustomerDto customer){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/"+UUID.randomUUID());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    public ResponseEntity updateCustomer(@PathVariable("customerId")UUID customerId,@RequestBody CustomerDto customer){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{customerId}"})
    public ResponseEntity deleteCustomer(@PathVariable("customerId")UUID customerId){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
