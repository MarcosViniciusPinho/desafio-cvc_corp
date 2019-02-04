package com.cvc.corp.desafio.resource.component;

import com.cvc.corp.desafio.config.DesafioProperty;
import com.cvc.corp.desafio.entity.Hotel;
import com.cvc.corp.desafio.resource.exception.RecurseNotFoundException;
import com.cvc.corp.desafio.resource.util.CallUtil;
import com.cvc.corp.desafio.resource.util.ObjetcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Classe responsavel por fazer a deserialização do objeto com as informações vindas do serviço consumido.
 */
@Component
public class IntegrationComponent {

    private RestTemplate restTemplate;

    @Autowired
    private DesafioProperty property;

    public IntegrationComponent() {
        this.restTemplate = new RestTemplate();
    }

    public Hotel[] callHotelsByCodeCity(Long cityCode) {
        return this.callHotels(cityCode, CallUtil.executeHotelsAvail(this.property.getEnviroment()));
    }

    public Hotel[] callHotelsByCode(Long id) {
        return this.callHotels(id, CallUtil.executeHotels(this.property.getEnviroment()));
    }

    public Hotel[] callHotels(Long code, String uri) {
        Hotel[] hotels = this.restTemplate.getForObject(uri, Hotel[].class, code);
        if(ObjetcUtil.isNull(hotels)) {
            throw new RecurseNotFoundException("Não foi encontrado hoteis com os dados informados",
                    "A API de hoteis não retornou nenhuma informação!");
        }
        return hotels;
    }

}
