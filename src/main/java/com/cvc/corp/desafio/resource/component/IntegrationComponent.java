package com.cvc.corp.desafio.resource.component;

import com.cvc.corp.desafio.resource.util.CallUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Classe responsavel por fazer a deserialização do objeto com as informações vindas do serviço consumido.
 */
@Component
public class IntegrationComponent {

    private RestTemplate restTemplate;

    public IntegrationComponent() {
        this.restTemplate = new RestTemplate();
    }

    public String callHotelsByCodeCity(Integer cityCode) {
        return this.restTemplate.getForObject(CallUtil.executeHotelsAvail(
                "https://cvcbackendhotel.herokuapp.com/", cityCode
                ), String.class);
    }

    public String callHotelsByCode(Integer id) {
        return this.restTemplate.getForObject(CallUtil.executeHotels(
                "https://cvcbackendhotel.herokuapp.com/", id
        ), String.class);
    }

}
