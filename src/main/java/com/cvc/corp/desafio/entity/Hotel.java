package com.cvc.corp.desafio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Hotel {

    private Long id;
    @JsonIgnore
    private String name;
    @JsonIgnore
    private Long cityCode;
    private String cityName;
    private List<Room> rooms;

}
