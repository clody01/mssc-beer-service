package com.clody2code.msscbeerservice001.web.controller;

import com.clody2code.msscbeerservice001.web.model.CustomerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getCustomer() throws Exception {
        mockMvc.perform(get("/api/v1/customer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveCustomer() throws Exception {
        CustomerDto customer = CustomerDto.builder().id(UUID.randomUUID()).name("Moussa Edwige").build();
        String customerToString = objectMapper.writeValueAsString(customer);
        mockMvc.perform(post("/api/v1/customer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerToString))
                .andExpect(status().isCreated());
    }

    @Test
    void updateCustomer()throws Exception {
        CustomerDto customer = CustomerDto.builder().id(UUID.randomUUID()).name("Moussa Edwige").build();
        String customerToString = objectMapper.writeValueAsString(customer);
        mockMvc.perform(put("/api/v1/customer/"+customer.getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerToString))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteCustomer() throws Exception{
        mockMvc.perform(delete("/api/v1/customer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}