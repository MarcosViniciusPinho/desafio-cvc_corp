package com.cvc.corp.desafio.service;

import com.cvc.corp.desafio.entity.Hotel;

public interface HotelService {

    Hotel executar(Hotel[] hotels, String dateCheckin, String dateCheckout, Long totalDeAdultos, Long totalDeCriancas);

}
