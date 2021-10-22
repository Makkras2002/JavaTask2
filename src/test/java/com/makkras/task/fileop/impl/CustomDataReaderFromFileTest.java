package com.makkras.task.fileop.impl;

import com.makkras.task.exception.FileInteractionException;
import com.makkras.task.fileop.DataReaderFromFile;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CustomDataReaderFromFileTest {
    private String filepath;
    private String filepath1;
    DataReaderFromFile readerFromFile;
    @BeforeMethod
    public void setUp() {
        filepath="errorFilepath.txt";
        filepath1="filesfoulder/source.txt";
        readerFromFile = new CustomDataReaderFromFile();
    }
    @Test(expectedExceptions = {FileInteractionException.class})
    public void invalidFilepathTest() throws FileInteractionException {
        List<String> list = readerFromFile.readDataFromFileIntoStringList(filepath);
    }
}