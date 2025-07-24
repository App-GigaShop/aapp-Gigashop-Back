package com.example.ventaComputadora.s_client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    private String title;
    private int quantity;
    private float price;

}
