package com.sb.put.mapping.example.controller;

import com.sb.put.mapping.example.request.CustomerRequest;
import com.sb.put.mapping.example.response.APIResponse;
import com.sb.put.mapping.example.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PutMapping("/update")
    public ResponseEntity<APIResponse> updateCustomer(@RequestBody CustomerRequest request) {
        return customerService.updateCustomer(request);
    }
}
