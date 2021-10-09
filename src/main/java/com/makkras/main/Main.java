package com.makkras.main;

import com.makkras.entity.CustomRepo;
import com.makkras.entity.impl.Sphere;
import com.makkras.exception.FileInteractionException;
import com.makkras.fileops.impl.CustomDataReaderFromFile;
import com.makkras.fileops.impl.FileDataOutputer;
import com.makkras.parser.impl.CustomDataParser;
import com.makkras.reposerv.RepoService;
import com.makkras.reposerv.impl.SphereRepoService;
import com.makkras.service.MathHandler;
import com.makkras.service.impl.SphereMathHandler;
import com.makkras.validator.DataValidator;
import com.makkras.validator.impl.CustomValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        boolean signal = true;
        Scanner scanner = new Scanner(System.in);
        RepoService repoService = new SphereRepoService();
        MathHandler mathHandler = new SphereMathHandler();
        DataValidator dataValidator = new CustomValidator();
        CustomRepo repo =null;
        CustomDataParser parser = new CustomDataParser();
        FileDataOutputer fileOutputer = new FileDataOutputer();
        CustomDataReaderFromFile dataReaderFromFile = new CustomDataReaderFromFile();
        boolean isRead = false;
        while (signal){
            logger.info("1. Read data from file.");
            logger.info("2. Show repo.");
            logger.info("3. Write data to file.");
            logger.info("4. Exit.");
            logger.info("5. Del by name from repo.");
            logger.info("6. Del by id from repo.");
            logger.info("7.Find by name and count capacitySize + areaSize.");
            logger.info("8.Find by id and count capacitySize + areaSize");
            switch (scanner.nextLine()){
                case "1":{
                    try {
                        repo = parser.extractToRepo(dataReaderFromFile.readDataFromFileIntoStringList("filesfoulder/source.txt"));
                    } catch (FileInteractionException e) {
                        logger.error(e.getMessage());
                    }
                    isRead = true;
                    break;
                }
                case "2":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        repo.showRepo();
                    }
                    break;
                }
                case "3":{
                    String newFileData = scanner.nextLine();
                    try {
                        fileOutputer.putDataIntoFile(newFileData, "filesfoulder/source.txt");
                    } catch (FileInteractionException e) {
                        logger.error(e.getMessage());
                    }
                    break;
                }
                case "4":{
                    return;
                }
                case "5":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info("write name: ");
                        repoService.delShapeByName(repo,scanner.nextLine());
                    }
                    break;
                }
                case "6":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info("write id: ");
                        String idToDel =scanner.nextLine();
                        if(dataValidator.checkIfNumber(idToDel)){
                            repoService.delShapeById(repo,Integer.parseInt(idToDel));
                        }else {
                            logger.error("Invalid data was entered.");
                        }
                    }
                    break;
                }
                case "7":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        List<Sphere> list = repoService.findShapeByName(repo,scanner.nextLine());
                        for (Sphere o : list){
                            logger.info("AreaSize: "+ mathHandler.countAreaSize(o) +" CapacitySize: "+ mathHandler.countCapacitySize(o));
                        }
                    }
                    break;
                }
                case "8":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        List<Sphere> list = repoService.findShapeById(repo,Integer.parseInt(scanner.nextLine()));
                        for (Sphere o : list){
                            logger.info("AreaSize: "+ mathHandler.countAreaSize(o) +" CapacitySize: "+ mathHandler.countCapacitySize(o));
                        }
                    }
                    break;
                }
            }
        }
    }
}
