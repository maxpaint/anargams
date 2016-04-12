package com.maxpaint;

import com.maxpaint.reader.TxtReader;
import com.maxpaint.reader.TxtReaderImpl;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: Max Danylenko<br/>
 * Date: 10.04.2016<br/>
 * Time: 19:17<br/>
 * To change this template use File | Settings | File Templates.
 */
public class Anagram {

    private final Collection<String> uniqueWords;

    private final Map<String, Collection<String>> keyAnagram = new ConcurrentHashMap<>();

    /**
     * Instantiates a new Anagram.
     *
     * @param uniqueWords insert collection of unique words
     */
    public Anagram(Collection<String> uniqueWords) {
        this.uniqueWords = uniqueWords;
    }

    /**
     * Gets anagrams from file
     *
     * @return the List of anagrams
     * @throws IOException the io exception
     */
    public List<Collection<String>> getAnagrams() throws IOException {
        final List<Collection<String>> result = Collections.synchronizedList( new ArrayList<>() );

        uniqueWords.parallelStream().forEach(line ->{
            final String word = line.trim().replaceAll("[^A-Za-z]", "").toLowerCase();
            final char[] chars = word.toCharArray();
            Arrays.sort(chars);

            final String sorted = new String(chars);
            if (keyAnagram.containsKey(sorted)) {
                Collection<String> anagrams = keyAnagram.get(sorted);
                anagrams.iterator().hasNext();
                anagrams.iterator().next();
                anagrams.add(word);
            } else {
                Collection<String> anagrams = Collections.synchronizedList(new ArrayList<>());
                anagrams.add(word);
                keyAnagram.put(sorted, anagrams);
            }

        });

        Set<Map.Entry<String, Collection<String>>> entrySet = keyAnagram.entrySet();
        entrySet.parallelStream().forEach(entry ->{
            Collection<String> line = entry.getValue();
            result.add(line);
        });

        return result;
    }
}
