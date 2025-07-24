package com.example.ventaComputadora.s_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InventarioClient {

    @Value("${inventario.api.url}")
    private String inventarioApiUrl;

    private final RestTemplate restTemplate;

    public InventarioClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void actualizarStockEnInventario(Long externalId, int cantidadReducida) {
        String url = inventarioApiUrl + "/api/productos/" + externalId + "/actualizar-stock";
        try {
            restTemplate.put(url, cantidadReducida);
        } catch (Exception e) {
            System.err.println("Error al actualizar el stock en el sistema de inventario: " + e.getMessage());
        }
    }
}
