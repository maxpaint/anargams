package com.maxpaint.reader;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: Max Danylenko<br/>
 * Date: 09.04.2016<br/>
 * Time: 21:12<br/>
 * To change this template use File | Settings | File Templates.
 */
public interface TxtReader {

    /**
     * Returns {@code true} if the has more lines in file.
     * @throws IOException
     * @return {@code true} if the txt file has more elements
     */
    boolean hasNext() throws IOException;


    /**
     * Returns the next line from txt file.
     * @return the next line in the file
     */
    String next();
}
