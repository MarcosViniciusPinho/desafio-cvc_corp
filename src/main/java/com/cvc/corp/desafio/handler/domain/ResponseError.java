package com.cvc.corp.desafio.handler.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseError {

    private String erro;
    private String exception;

}
