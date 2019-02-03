package com.cvc.corp.desafio.service.impl;

import com.cvc.corp.desafio.entity.Hotel;
import com.cvc.corp.desafio.entity.Room;
import com.cvc.corp.desafio.resource.util.LocalDateUtil;
import com.cvc.corp.desafio.service.HotelService;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {

    @Override
    public void executar(Hotel[] hotels, String dateCheckin, String dateCheckout, Long totalDeAdultos, Long totalDeCriancas) {
        Long quantidadeDeDias = LocalDateUtil.getTotalDoPeridoDeDias(dateCheckin, dateCheckout);
        for(Hotel hotel : hotels) {
            for(Room room : hotel.getRooms()) {
                room.setTotalPrice(room.calcularComissao(quantidadeDeDias, totalDeAdultos, totalDeCriancas));
            }
        }
    }


}
