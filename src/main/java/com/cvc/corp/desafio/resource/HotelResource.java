package com.cvc.corp.desafio.resource;

import com.cvc.corp.desafio.entity.Hotel;
import com.cvc.corp.desafio.resource.component.IntegrationComponent;
import com.cvc.corp.desafio.service.HotelService;
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
@RequestMapping("/hotels")
public class HotelResource {

    @Autowired
    private IntegrationComponent integration;

    @Autowired
    private HotelService service;

    @GetMapping(value = "/city/{cityCode}/checkin/{dateCheckin}/checkout/{dateCheckout}/adultos/{totalDeAdultos}/criancas/{totalDeCriancas}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Hotel> getHotelsByCodeCity(@PathVariable(value = "cityCode") Long cityCode,
                                                       @PathVariable(value = "dateCheckin") String dateCheckin,
                                                       @PathVariable(value = "dateCheckout") String dateCheckout,
                                                       @PathVariable(value = "totalDeAdultos") Long totalDeAdultos,
                                                       @PathVariable(value = "totalDeCriancas") Long totalDeCriancas) {
        Hotel[] hotels = this.integration.callHotelsByCodeCity(cityCode);
        Hotel hotel = this.service.executar(hotels, dateCheckin, dateCheckout, totalDeAdultos, totalDeCriancas);
        return ResponseEntity.ok(hotel);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Hotel[]> getHotelsByCode(@PathVariable(value = "id") Long id) {
        Hotel[] hotels = this.integration.callHotelsByCode(id);
        return ResponseEntity.ok(hotels);//TODO Melhorar isto, pois o valor retornado é sempre 1(um) portanto não há necessidade de retornar uma lista sempre.
    }

}
