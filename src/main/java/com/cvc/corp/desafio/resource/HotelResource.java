package com.cvc.corp.desafio.resource;

import com.cvc.corp.desafio.resource.component.IntegrationComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe criada para fazer integração com a API de hoteis
 */
@RestController
@RequestMapping("/hoteis")
public class HotelResource {

    @Autowired
    private IntegrationComponent integration;

    @GetMapping(value = "/city/{cityCode}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getHotelsByCodeCity(@PathVariable(value = "cityCode") Integer cityCode) {
        String hoteis = this.integration.callHotelsByCodeCity(cityCode);
        return ResponseEntity.ok(hoteis);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getHotelsByCode(@PathVariable(value = "id") Integer id) {
        String hoteis = this.integration.callHotelsByCode(id);
        return ResponseEntity.ok(hoteis);
    }

}
