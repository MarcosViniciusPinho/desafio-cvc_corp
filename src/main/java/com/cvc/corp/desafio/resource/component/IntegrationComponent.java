package com.cvc.corp.desafio.resource.component;

import com.cvc.corp.desafio.entity.Hotel;
import com.cvc.corp.desafio.resource.util.CallUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Classe responsavel por fazer a deserialização do objeto com as informações vindas do serviço consumido.
 */
@Component
public class IntegrationComponent {

    private RestTemplate restTemplate;
    private static String enviroment = "https://cvcbackendhotel.herokuapp.com/";//TODO melhorar isto e deixar isso a cargo do arquivo de configuração

    public IntegrationComponent() {
        this.restTemplate = new RestTemplate();
    }

    public Hotel[] callHotelsByCodeCity(Long cityCode) {
        return this.restTemplate.getForObject(CallUtil.executeHotelsAvail(
                enviroment, cityCode
        ), Hotel[].class);
    }

    public Hotel[] callHotelsByCode(Long id) {
        return this.restTemplate.getForObject(CallUtil.executeHotels(
                enviroment, id
        ), Hotel[].class);
    }

}
