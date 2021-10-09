package com.makkras.fileops.impl;

import com.makkras.exception.FileInteractionException;
import com.makkras.fileops.FileOutputer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileDataOutputer implements FileOutputer {
    public void putDataIntoFile(String data, String filepath) throws FileInteractionException {
        try (FileWriter fileWriter = new FileWriter(filepath,true);BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            bufferedWriter.write(data + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new FileInteractionException("File interaction error."+ e.getMessage(),e.getCause());
        }
    }
}
