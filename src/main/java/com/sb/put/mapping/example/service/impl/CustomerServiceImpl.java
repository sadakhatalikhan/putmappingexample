package com.sb.put.mapping.example.service.impl;

import com.sb.put.mapping.example.model.CustomerModel;
import com.sb.put.mapping.example.request.CustomerRequest;
import com.sb.put.mapping.example.response.APIResponse;
import com.sb.put.mapping.example.response.CustomerResponse;
import com.sb.put.mapping.example.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static List<CustomerModel> customers = new ArrayList<>();
    private static AtomicInteger c = new AtomicInteger(1);

    static {
        customers.add(new CustomerModel(c.getAndIncrement(), "testUser1", 21, "7234567811", "testuser1@gmail.com", "Bangalore", LocalDate.now()));
        customers.add(new CustomerModel(c.getAndIncrement(), "testUser2", 22, "7234567812", "testuser2@gmail.com", "Hyderabad", LocalDate.now()));
        customers.add(new CustomerModel(c.getAndIncrement(), "testUser3", 23, "7234567813", "testuser3@gmail.com", "Chennai", LocalDate.now()));
        customers.add(new CustomerModel(c.getAndIncrement(), "testUser4", 24, "7234567814", "testuser4@gmail.com", "Pune", LocalDate.now()));
    }

    @Override
    public ResponseEntity<APIResponse> updateCustomer(CustomerRequest request) {

        Optional<CustomerModel> customerModelOptional = customers.stream()
                .filter(customerModel -> customerModel.getCustomerId() == request.getCustomerId())
                .map(customerModel -> {
                    customerModel.setCustomerName(request.getCustomerName());
                    customerModel.setCustomerAge(request.getCustomerAge());
                    customerModel.setCustomerMobileNumber(request.getCustomerMobileNumber());
                    customerModel.setCustomerEmailAddress(request.getCustomerEmailAddress());
                    return customerModel;
                })
                .findFirst();

        return customerModelOptional.map(customerResponse -> ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(000)
                        .data(CustomerResponse.builder()
                                .customerId(customerResponse.getCustomerId())
                                .customerName(customerResponse.getCustomerName())
                                .customerAge(customerResponse.getCustomerAge())
                                .customerMobileNumber(customerResponse.getCustomerMobileNumber())
                                .customerEmailAddress(customerResponse.getCustomerEmailAddress())
                                .customerAddress(customerResponse.getCustomerAddress())
                                .createdDate(customerResponse.getCreatedDate())
                                .build()
                        )
                        .build()
        )).orElseGet(() -> ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(999)
                        .data("Customer is not available")
                        .build()
        ));
    }
}
