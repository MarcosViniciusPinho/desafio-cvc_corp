package com.cvc.corp.desafio.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Room {

    private Long roomID;
    private String categoryName;
    private Price price;

}
