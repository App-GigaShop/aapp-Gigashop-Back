package com.example.ventaComputadora.MercadoPagoConfig;

import com.mercadopago.MercadoPagoConfig;

public class ConfiguracionMercadoPago {

    public static void main(String[] args) {
        try {
            MercadoPagoConfig.setAccessToken("TU_ACCESS_TOKEN");
            System.out.println("Access Token configurado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
