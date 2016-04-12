package com.maxpaint;

import com.maxpaint.reader.TxtReader;
import com.maxpaint.reader.TxtReaderImpl;
import com.maxpaint.utils.Printer;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: Max Danylenko<br/>
 * Date: 09.04.2016<br/>
 * Time: 22:24<br/>
 * To change this template use File | Settings | File Templates.
 */
public class AnagramMain {

    public static void main(String[] args) throws IOException {
        if (args == null || args.length == 0 || args[0] == null || args[0].isEmpty()) {
            throw new IllegalArgumentException("Please insert correct file path");
        }

        final String path = args[0];

        Anagram anagram = new Anagram(getUniqueWords(path));

        List<Collection<String>> anagrams = anagram.getAnagrams();

        anagrams.forEach(line -> {
            if (line.size() > 1)
                System.out.println(Printer.getString(line));

        });


    }

    /*
    * get only unique words from file
    * */
    private static Set<String> getUniqueWords(String path) throws IOException {
        final Set<String> result = new HashSet<>();
        final TxtReader txtReader = new TxtReaderImpl(path);
        while (txtReader.hasNext()){
            result.add(txtReader.next());
        }

        return result;
    }

    // -XX:ParallelGCThreads=15 -XX:ConcGCThreads=15 -XX:+UseLargePages -XX:NewSize=50m
}
