package com.cvc.corp.desafio.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("desafio")
@Setter
@Getter
@NoArgsConstructor
public class DesafioProperty {

    private String enviroment;

}
