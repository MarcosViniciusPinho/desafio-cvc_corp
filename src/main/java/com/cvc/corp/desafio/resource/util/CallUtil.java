package com.cvc.corp.desafio.resource.util;

/**
 * Classe responsavel por fazer a build da uri.
 */
public final class CallUtil {

    private CallUtil() {}

    public static String executeHotelsAvail(String enviroment) {
        return build(enviroment, "hotels/avail/{cityCode}");
    }

    public static String executeHotels(String enviroment) {
        return build(enviroment, "hotels/{id}");
    }

    private static String build(String enviroment, String uri) {
        StringBuilder url = new StringBuilder();
        url.append(enviroment);
        url.append(uri);
        return url.toString();
    }

}
