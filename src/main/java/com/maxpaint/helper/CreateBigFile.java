package com.maxpaint.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: Max Danylenko<br/>
 * Date: 09.04.2016<br/>
 * Time: 19:58<br/>
 * To change this template use File | Settings | File Templates.
 */
//1,022,000
public class CreateBigFile {

    public static void main(String[] args) throws IOException {
        String path = args[0];
        File resFile = Paths.get(path + "result2.txt").toFile();

        File dir = new File(path);
        File[] files = dir.listFiles();


        assert files != null;
        final int[] count = {0};

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(resFile))) {
            while (count[0] <= 100_000_000) {
                for (File file : files) {
                    Stream<String> streamFromFiles = Files.lines(file.toPath());
                    streamFromFiles.filter(item -> !item.isEmpty()).forEach(line -> {
                                String[] words = line.replaceAll("[^A-Za-z]", " ")
                                        .trim()
                                        .replaceAll(" +", " ")
                                        .toLowerCase().split(" ");

                                for (String element : words) {
                                    String res = element.replaceAll("[^A-Za-z]", " ").trim();
                                    if (res.isEmpty() || res.length() == 1)
                                        continue;


                                    try {
                                        bw.write(res);
                                        bw.newLine();
                                        count[0]++;
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }


                                }
                            }
                    );
                }
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
