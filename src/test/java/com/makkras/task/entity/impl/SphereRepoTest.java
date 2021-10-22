package com.makkras.task.entity.impl;

import com.makkras.task.entity.CustomRepo;
import com.makkras.task.entity.factory.CustomRepoFactory;
import com.makkras.task.entity.factory.impl.RepoFactory;
import com.makkras.task.exception.FileInteractionException;
import com.makkras.task.fileop.impl.CustomDataReaderFromFile;
import com.makkras.task.parser.impl.CustomDataParser;
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