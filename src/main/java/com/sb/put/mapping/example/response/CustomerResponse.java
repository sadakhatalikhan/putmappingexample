package com.sb.put.mapping.example.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public class CustomerResponse {
    private long customerId;
    private String customerName;
    private int customerAge;
    private String customerMobileNumber;
    private String customerEmailAddress;
    private String customerAddress;
    private LocalDate createdDate;
}
