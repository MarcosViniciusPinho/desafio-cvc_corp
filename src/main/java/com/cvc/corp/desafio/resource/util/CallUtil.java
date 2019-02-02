package com.cvc.corp.desafio.resource.util;

/**
 * Classe responsavel por fazer a build da uri.
 */
public final class CallUtil {

    public static String executeHotelsAvail(String enviroment, Integer cityCode) {
        return build(enviroment, cityCode, "hotels/avail/");
    }

    public static String executeHotels(String enviroment, Integer id) {
        return build(enviroment, id, "hotels/");
    }

    private static String build(String enviroment, Integer code, String uri) {
        StringBuilder url = new StringBuilder();
        url.append(enviroment);
        url.append(uri);
        url.append(code);
        return url.toString();
    }

}
