package com.maxpaint.utils;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: Max Danylenko<br/>
 * Date: 09.04.2016<br/>
 * Time: 21:35<br/>
 * To change this template use File | Settings | File Templates.
 */
public class Printer {

    /**
     * Convert collection to line with elements with comma separator
     * separator
     * @param  collection The sequence of char values to be replaced
     * @return  The resulting string
     */
    public static String getString(Collection<String> collection) {
        if (collection == null || collection.size() == 0)
            return "";

        StringBuilder b = new StringBuilder();

        int i = 0;
        for (String s: collection){
            b.append(s);
            if (i == collection.size()-1){
                return b.toString();
            }
            b.append(", ");
            i++;
        }
        return "";
    }
}
