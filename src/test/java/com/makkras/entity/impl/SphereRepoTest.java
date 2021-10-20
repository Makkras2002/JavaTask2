package com.makkras.entity.impl;

import com.makkras.entity.CustomRepo;
import com.makkras.entity.factory.CustomRepoFactory;
import com.makkras.entity.factory.impl.RepoFactory;
import com.makkras.exception.FileInteractionException;
import com.makkras.fileop.impl.CustomDataReaderFromFile;
import com.makkras.parser.impl.CustomDataParser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SphereRepoTest {
    private CustomRepo repo;
    private CustomRepoFactory factory;
    private CustomDataReaderFromFile dataReaderFromFile;
    @BeforeMethod
    public void setUp() {
        factory= new RepoFactory();
        dataReaderFromFile = new CustomDataReaderFromFile();
    }
    @Test
    public void sortByRadiusTest() throws FileInteractionException {
        repo = factory.createRepo(CustomDataParser.getInstance().extractToList(dataReaderFromFile.readDataFromFileIntoStringList("filesfoulder/testsource.txt")));
        repo.sortRepoByRadius();
        assertTrue(repo.getList().get(0).getName().equals("Tom"));
    }
}