package com.sb.put.mapping.example.service;

import com.sb.put.mapping.example.request.CustomerRequest;
import com.sb.put.mapping.example.response.APIResponse;
import org.springframework.http.ResponseEntity;


public interface CustomerService {
    ResponseEntity<APIResponse> updateCustomer(CustomerRequest request);
}
