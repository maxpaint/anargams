package com.maxpaint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: Max Danylenko<br/>
 * Date: 11.04.2016<br/>
 * Time: 22:48<br/>
 * To change this template use File | Settings | File Templates.
 */
public class MainMergeTwoArrays {

    private static int[] a = {2,4,5,9,9};
    private static int[] b = {0,1,2,3,4};

    public static void main(String[] args) throws IOException {
        List<Integer> result = new ArrayList<>();

        int secondLastIndex = 0;
        for (int i = 0; i < a.length; i++) {
            int first = a[i];

            for (int j = secondLastIndex; j < b.length; j++) {
                int second = b[j];
                if(first < second ){
                    result.add(first);
                    break;
                }else if(first == second) {
                    result.add(first);
                    result.add(second);
                    secondLastIndex++;
                    break;
                }else{
                    result.add(second);
                    secondLastIndex++;
                }
            }
            if(secondLastIndex == b.length){
                result.add(first);
            }

        }

        System.out.println(result.toString());
    }

}
