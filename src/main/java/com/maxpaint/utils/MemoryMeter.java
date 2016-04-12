package com.maxpaint.utils;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: Max Danylenko<br/>
 * Date: 09.04.2016<br/>
 * Time: 19:40<br/>
 * To change this template use File | Settings | File Templates.
 */
public class MemoryMeter {
    private static int mb = 1024 * 1024;

    private static Runtime instance = Runtime.getRuntime();

    /**
     * Get total memory long.
     *
     * @return the long
     */
    public static long getTotalMemory(){
        return instance.totalMemory() / mb;
    }


    /**
     * Get free memory long.
     *
     * @return  long
     */
    public static long getFreeMemory(){
        return instance.freeMemory() / mb;
    }

    /**
     * Gets used memory.
     *
     * @return long
     */
    public static long getUsedMemory() {
        final long total = instance.totalMemory();
        final long freeMemory = instance.freeMemory();
        return ( total - freeMemory ) / mb;
    }
}

