package com.example.ventaComputadora.MercadoPagoConfig;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/webhooks")
public class WebhookController {

    @PostMapping
    public String handleWebhook(@RequestBody Map<String, Object> webhookData) {
        System.out.println("Webhook recibido: " + webhookData);

        // Procesar el estado del pago
        String paymentId = (String) webhookData.get("id");
        String status = (String) webhookData.get("status");

        // Aquí puedes actualizar el estado del pago en tu base de datos

        return "OK";
    }
}
