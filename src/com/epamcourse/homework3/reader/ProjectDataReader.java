package com.epamcourse.homework3.reader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProjectDataReader {
    private static final String DEFAULT_PATH = "input/inputData.txt";

    public List<String> readAllData(String filename) {
        Path path = Paths.get(DEFAULT_PATH);
        List<String> dataLines;

        if (filename != null) {
            if (Files.exists(Paths.get(filename))){
                path = Paths.get(filename);
            }
        }

        try (Stream<String> lineStream = Files.lines(path)){
            dataLines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error while opening file", e);
        }

        return dataLines;
    }
}