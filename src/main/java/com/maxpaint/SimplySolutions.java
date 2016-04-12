package com.maxpaint;

import com.maxpaint.utils.Printer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Hello world!
 */
//return value.replaceAll("/[^A-Za-z0-9 ]/", "");
public class SimplySolutions {
    public static void main(String[] args) throws IOException {
        Map<String, List<String>> keyAnagram = new HashMap<>();

        List<String> allWords = Files.readAllLines(Paths.get(args[0]));

        allWords.forEach(item -> {
            final char[] chars = item.toCharArray();
            Arrays.sort(chars);

            final String sorted = new String(chars);

            if (keyAnagram.containsKey(sorted)) {
                List<String> anagrams = keyAnagram.get(sorted);
                anagrams.add(item);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(item);
                keyAnagram.put(sorted, anagrams);
            }
        });

        Set<Map.Entry<String, List<String>>> entries = keyAnagram.entrySet();
        entries.forEach(entry -> {
            List<String> result = entry.getValue();
            if(result.size() > 1)
                System.out.println(Printer.getString(result));
        });
    }


}
