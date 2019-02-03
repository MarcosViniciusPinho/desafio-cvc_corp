package com.cvc.corp.desafio.resource.component;

import com.cvc.corp.desafio.config.DesafioProperty;
import com.cvc.corp.desafio.entity.Hotel;
import com.cvc.corp.desafio.resource.util.CallUtil;
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
        return this.restTemplate.getForObject(CallUtil.executeHotelsAvail(this.property.getEnviroment()), Hotel[].class, cityCode);
    }

    public Hotel[] callHotelsByCode(Long id) {
        return this.restTemplate.getForObject(CallUtil.executeHotels(this.property.getEnviroment()), Hotel[].class, id);
    }

}
