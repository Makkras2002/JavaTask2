package com.makkras.task.fileop;

import com.makkras.task.exception.FileInteractionException;

import java.util.List;

public interface DataReaderFromFile {
    List<String> readDataFromFileIntoStringList(String filepath) throws FileInteractionException;
}
