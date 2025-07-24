package com.example.ventaComputadora.MercadoPagoConfig;

import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.resources.preference.Preference;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @PostMapping("/create-preference")
    public Map<String, String> createPreference(@RequestBody Map<String, Object> paymentData) {
        try {
            // Crear cliente de preferencias
            PreferenceClient client = new PreferenceClient();

            // Crear un ítem
            PreferenceItemRequest item = PreferenceItemRequest.builder()
                    .title((String) paymentData.get("title")) // Nombre del producto
                    .quantity((Integer) paymentData.get("quantity")) // Cantidad
                    .unitPrice(new BigDecimal(String.valueOf(paymentData.get("price")))) // Precio unitario
                    .build();

            // Crear la preferencia
            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(List.of(item))
                    .build();

            // Guardar la preferencia
            Preference preference = client.create(preferenceRequest);

            // Retornar la URL para redirigir al cliente
            return Map.of("initPoint", preference.getInitPoint());
        } catch (Exception e) {
            throw new RuntimeException("Error al crear la preferencia: " + e.getMessage());
        }
    }
}
