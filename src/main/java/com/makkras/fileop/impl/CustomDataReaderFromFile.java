package com.makkras.fileop.impl;

import com.makkras.exception.FileInteractionException;
import com.makkras.fileop.DataReaderFromFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomDataReaderFromFile implements DataReaderFromFile {
    public List<String> readDataFromFileIntoStringList(String filepath) throws FileInteractionException {
        List<String> list =new ArrayList<>();
        try (FileReader fileReader = new FileReader(filepath);BufferedReader bufferedReader =new BufferedReader(fileReader)){
            list = bufferedReader.lines().collect(Collectors.toList());
            return list;
        } catch (IOException e) {
            throw new FileInteractionException("File interaction error: " + e.getMessage(),e.getCause());
        }
    }
}
