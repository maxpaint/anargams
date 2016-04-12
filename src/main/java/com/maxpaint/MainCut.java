package com.maxpaint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.sort;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: Max Danylenko<br/>
 * Date: 11.04.2016<br/>
 * Time: 23:11<br/>
 * To change this template use File | Settings | File Templates.
 */
public class MainCut {

    private static int[] lengths = {8, 1, 2, 3, 4, 3, 3, 2, 1}; //8641

    public static void main(String[] args) throws IOException {
        boolean flag = true;
        List<Integer> result = new ArrayList<>();
        while (flag) {

            List<Integer> res = new ArrayList<>();

            Arrays.sort(lengths);

            int min = lengths[0];
            int minInd = 0;
            while(min <= 0){
                minInd++;
                min = lengths[minInd];
            }

            int cutting = 0;
            for (int i = 0; i < lengths.length; i++) {
                int resCut = lengths[i] - min;
                cutting++;

                if (resCut != 0 || lengths.length == 1) {
                    res.add(resCut);
                }

            }

            result.add(cutting);

            if (res.size() == 1) {
                result.add(1);
                flag = false;
                break;
            }
            lengths = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                lengths[i] = res.get(i);
            }
        }

        for (Integer item : result) {
            System.out.println(item);
        }


    }


    /*{
        sort(lengths);
        int min = lengths[0];
        int cutting = 0;
        for (int i = 0; i <lengths.length ; i++) {
            if(lengths[i] != 0){
                lengths[i] = lengths[i] - min;
                cutting++;
            }

        }
    }*/

}

