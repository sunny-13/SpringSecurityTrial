package com.security.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    private String customerId;
    private String customerName;
    private String customerPassword;
}
