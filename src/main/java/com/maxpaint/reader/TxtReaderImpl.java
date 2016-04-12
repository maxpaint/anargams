package com.maxpaint.reader;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: Max Danylenko<br/>
 * Date: 09.04.2016<br/>
 * Time: 16:49<br/>
 * To change this template use File | Settings | File Templates.
 */
public class TxtReaderImpl implements TxtReader {

    private BufferedReader reader = null;
    private String nextLine;

    public TxtReaderImpl(String path) throws IOException {
        reader = newBufferedReader(Paths.get(path));
    }

    @Override
    public boolean hasNext() throws IOException {
            nextLine = reader.readLine();

        return nextLine != null && !nextLine.isEmpty();

    }

    @Override
    public String next() {
        return nextLine;
    }

    private BufferedReader newBufferedReader(Path path) throws IOException
    {
        CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();
        InputStream stream = path.getFileSystem().provider().newInputStream(path);
        return new BufferedReader(new InputStreamReader(stream, decoder));
    }
}
