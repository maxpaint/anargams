package com.maxpaint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: Max Danylenko<br/>
 * Date: 11.04.2016<br/>
 * Time: 22:08<br/>
 * To change this template use File | Settings | File Templates.
 */
public class MainMergeTwoArraysSevond {

    private static int[] a = {2,4,5,9,9};
    private static int[] b = {0,1,2,3,4};

    public static void main(String[] args) throws IOException {
        int[] result = new int[a.length + b.length];

        int resultIndex = 0;
        int secondLastIndex = 0;
        for (int i = 0; i < a.length; i++) {
            int first = a[i];

            for (int j = secondLastIndex; j < b.length; j++) {
                int second = b[j];
                if(first < second ){
                    result[resultIndex] = first;
                    resultIndex++;
                    break;
                }else if(first == second) {
                    result[resultIndex] = second;
                    resultIndex++;

                    secondLastIndex++;

                    if(secondLastIndex != b.length){
                        result[resultIndex] = first;
                        resultIndex++;
                    }

                    break;
                }else{
                    result[resultIndex] = second;
                    resultIndex++;
                    secondLastIndex++;
                }
            }

            if(secondLastIndex == b.length){
                result[resultIndex] = first;
                resultIndex++;
            }

        }

        System.out.println(Arrays.toString(result));

    }

    /* private static void fdf(){
        int[] result = new int[a.length + b.length];

        int resultIndex = 0;
        int secondLastIndex = 0;
        for (int i = 0; i < a.length; i++) {
            int first = a[i];

            for (int j = secondLastIndex; j < b.length; j++) {
                int second = b[j];
                if(first < second ){
                    result[resultIndex] = first;
                    resultIndex++;
                    break;
                }else if(first == second) {
                    result[resultIndex] = first;
                    resultIndex++;
                    result[resultIndex] = second;
                    resultIndex++;
                    secondLastIndex++;
                    break;
                }else{
                    result[resultIndex] = second;
                    resultIndex++;
                    secondLastIndex++;
                }
            }
            if(secondLastIndex == b.length){
                result[resultIndex] = first;
                resultIndex++;
            }

        }

        System.out.println(Arrays.toString(result));
    }*/
}
