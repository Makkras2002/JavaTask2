package com.makkras.main;

import com.makkras.entity.CustomRepo;
import com.makkras.entity.impl.Sphere;
import com.makkras.exception.FileInteractionException;
import com.makkras.fileops.impl.CustomDataReaderFromFile;
import com.makkras.fileops.impl.FileDataOutputer;
import com.makkras.parser.impl.CustomDataParser;
import com.makkras.reposerv.RepoService;
import com.makkras.reposerv.impl.SphereRepoService;
import com.makkras.service.ChangeHandler;
import com.makkras.service.MathHandler;
import com.makkras.service.impl.SphereChangeHandler;
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
        ChangeHandler changeHandler = new SphereChangeHandler();
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
            logger.info("9.Find by name and count capacity correlation of sphere divided by XY area.");
            logger.info("10.Find by id and check does sphere touch any cord area.");
            logger.info("11.Find by areaSize in range.");
            logger.info("12.Find by capacitySize in range.");
            logger.info("13.Find by center in range from origin.");
            logger.info("14.Sort by name.");
            logger.info("15.Sort by id.");
            logger.info("16.Sort by radius.");
            logger.info("17.Sort by XAxis coordinates.");
            logger.info("18.Find by name and change radius.");
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
                        String id = scanner.nextLine();
                        if(!dataValidator.checkIfNumber(id)){
                            logger.error("Invalid data was entered.");
                        }else {
                            List<Sphere> list = repoService.findShapeById(repo,Integer.parseInt(id));
                            for (Sphere o : list){
                                logger.info("AreaSize: "+ mathHandler.countAreaSize(o) +" CapacitySize: "+ mathHandler.countCapacitySize(o));
                            }
                        }

                    }
                    break;
                }
                case "9":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        List<Sphere> list = repoService.findShapeByName(repo,scanner.nextLine());
                        for (Sphere o : list){
                            logger.info("Capacity correlation : "+ mathHandler.countCapacityCorrelationCreatedByCordSpaceXYCutSphere(o));
                        }
                    }
                    break;
                }
                case "10":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        String id = scanner.nextLine();
                        if(!dataValidator.checkIfNumber(id)){
                            logger.error("Invalid data was entered.");
                        }else {
                            List<Sphere> list = repoService.findShapeById(repo,Integer.parseInt(id));
                            for (Sphere o : list){
                                logger.info("Does touch any cord area: " + mathHandler.doesSphereTouchAnyCordArea(o));
                            }
                        }
                    }
                    break;
                }
                case "11":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info("min : ");
                        String min = scanner.nextLine();
                        logger.info("max : ");
                        String max = scanner.nextLine();
                        if(!dataValidator.checkIfNumber(min) || !dataValidator.checkIfNumber(max)){
                            logger.error("Invalid data was entered.");
                        }else {
                            List<Sphere> list = repoService.findShapesWhichAreaSizeIsInRange(repo,Double.parseDouble(min),Double.parseDouble(max));
                            for (Sphere o : list){
                                logger.info(o.toString());
                            }
                        }
                    }
                    break;
                }
                case "12":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info("min : ");
                        String min = scanner.nextLine();
                        logger.info("max : ");
                        String max = scanner.nextLine();
                        if(!dataValidator.checkIfNumber(min) || !dataValidator.checkIfNumber(max)){
                            logger.error("Invalid data was entered.");
                        }else {
                            List<Sphere> list = repoService.findShapesWhichCapacitySizeIsInRange(repo,Double.parseDouble(min),Double.parseDouble(max));
                            for (Sphere o : list){
                                logger.info(o.toString());
                            }
                        }
                    }
                    break;
                }
                case "13":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info("min : ");
                        String min = scanner.nextLine();
                        logger.info("max : ");
                        String max = scanner.nextLine();
                        if(!dataValidator.checkIfNumber(min) || !dataValidator.checkIfNumber(max)){
                            logger.error("Invalid data was entered.");
                        }else {
                            List<Sphere> list = repoService.findShapesWhichCenterIsInRangeFromOrigin(repo,Double.parseDouble(min),Double.parseDouble(max));
                            for (Sphere o : list){
                                logger.info(o.toString());
                            }
                        }
                    }
                    break;
                }
                case "14":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        repoService.sortRepoByName(repo);
                    }
                    break;
                }
                case "15":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        repoService.sortRepoById(repo);
                    }
                    break;
                }
                case "16":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        repoService.sortRepoByRadius(repo);
                    }
                    break;
                }
                case "17":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        repoService.sortRepoByXCordOfCenter(repo);
                    }
                    break;
                }
                case "18":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info("Enter id: ");
                        String id = scanner.nextLine();
                        logger.info("Enter radius: ");
                        String newRadius = scanner.nextLine();
                        if(!dataValidator.checkIfNumber(id) || !dataValidator.checkIfNumber(newRadius)){
                            logger.error("Invalid data was entered.");
                        }else {
                            if(Double.parseDouble(newRadius)<=0){
                                logger.error("Invalid data was entered.");
                            }else {
                                List<Sphere> list = repoService.findShapeById(repo,Integer.parseInt(id));
                                for (Sphere o : list){
                                    changeHandler.changeRadius(o,Double.parseDouble(newRadius));
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
    }
}
