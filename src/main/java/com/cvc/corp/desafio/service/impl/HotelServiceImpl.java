package com.cvc.corp.desafio.service.impl;

import com.cvc.corp.desafio.entity.Hotel;
import com.cvc.corp.desafio.entity.Room;
import com.cvc.corp.desafio.resource.util.LocalDateUtil;
import com.cvc.corp.desafio.service.HotelService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class HotelServiceImpl implements HotelService {

    @Override
    public Hotel executar(Hotel[] hotels, String dateCheckin, String dateCheckout, Long totalDeAdultos, Long totalDeCriancas) {
        Hotel hotel = hotels[0];
        Long quantidadeDeDias = LocalDateUtil.getTotalDoPeridoDeDias(dateCheckin, dateCheckout);
        BigDecimal valorAcumulado = BigDecimal.ZERO;
        for(Hotel hotelOther : hotels) {
            for(Room room : hotelOther.getRooms()) {
                valorAcumulado = valorAcumulado.add(room.calcularComissao(quantidadeDeDias, totalDeAdultos, totalDeCriancas));
                hotel.getRooms().get(0).setTotalPrice(valorAcumulado);
            }
        }
        return hotel;
    }


}
