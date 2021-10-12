package com.makkras.fileops;

import com.makkras.exception.FileInteractionException;

import java.util.List;

public interface DataReaderFromFile {
    List<String> readDataFromFileIntoStringList(String filepath) throws FileInteractionException;
}
