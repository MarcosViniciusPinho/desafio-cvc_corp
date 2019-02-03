package com.cvc.corp.desafio.resource.exception;

import lombok.Getter;

@Getter
public class RecurseNotFoundException extends RuntimeException {

    private String mensagemClient;

    public RecurseNotFoundException(String mensagemClient, String mensagemException) {
        super(mensagemException);
        this.mensagemClient = mensagemClient;
    }

}
