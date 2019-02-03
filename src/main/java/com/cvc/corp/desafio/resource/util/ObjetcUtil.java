package com.cvc.corp.desafio.resource.util;

public class ObjetcUtil {

    public ObjetcUtil() {}

    public static boolean isNull(Object[] object){
        return object == null || object.length == 0;
    }

    public static boolean isNotNull(Object[] object) {
        return !isNull(object);
    }
}
