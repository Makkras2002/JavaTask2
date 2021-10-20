package com.makkras.main;

import com.makkras.entity.CustomRepo;
import com.makkras.entity.factory.CustomRepoFactory;
import com.makkras.entity.factory.impl.RepoFactory;
import com.makkras.entity.impl.Sphere;
import com.makkras.entity.impl.WareHouse;
import com.makkras.exception.FileInteractionException;
import com.makkras.fileop.impl.CustomDataReaderFromFile;
import com.makkras.fileop.impl.FileDataOutputer;
import com.makkras.observer.impl.SphereObserver;
import com.makkras.parser.impl.CustomDataParser;
import com.makkras.service.ChangeHandler;
import com.makkras.service.MathHandler;
import com.makkras.service.impl.SphereChangeHandler;
import com.makkras.service.impl.SphereMathHandler;
import com.makkras.specification.impl.*;
import com.makkras.validator.impl.CustomValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        boolean signal = true;
        Scanner scanner = new Scanner(System.in);
        MathHandler mathHandler = new SphereMathHandler();
        ChangeHandler changeHandler = new SphereChangeHandler();
        CustomRepo repo =null;
        CustomRepoFactory repoFactory = new RepoFactory();
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
            logger.info("18.Find by id and change radius.");
            logger.info("19.Show WareHouse.");
            logger.info("20.Find by id and change XYZ.");
            switch (scanner.nextLine()){
                case "1":{
                    try {
                        repo = repoFactory.createRepo(CustomDataParser.getInstance().extractToList(dataReaderFromFile.readDataFromFileIntoStringList("filesfoulder/source.txt")));
                        WareHouse.getInstance().fillMap(repo);
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
                        for (Sphere o : repo.getList()){
                            logger.info(o.toString());
                        }
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
                        String name = scanner.nextLine();
                        for(Sphere o : repo.query(new NameSpecification(name))){
                            repo.removeSphere(o);
                        }
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
                        if(CustomValidator.getInstance().checkIfNumber(idToDel)){
                            for(Sphere o : repo.query(new IdSpecification(Integer.parseInt(idToDel)))){
                                repo.removeSphere(o);
                            }
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
                        logger.info("write name: ");
                        String name = scanner.nextLine();
                        for (Sphere o : repo.query(new NameSpecification(name))){
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
                        if(!CustomValidator.getInstance().checkIfNumber(id)){
                            logger.error("Invalid data was entered.");
                        }else {
                            for (Sphere o : repo.query(new IdSpecification(Integer.parseInt(id)))){
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
                        String name = scanner.nextLine();
                        for (Sphere o : repo.query(new NameSpecification(name))){
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
                        if(!CustomValidator.getInstance().checkIfNumber(id)){
                            logger.error("Invalid data was entered.");
                        }else {
                            for (Sphere o : repo.query(new IdSpecification(Integer.parseInt(id)))){
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
                        if(!CustomValidator.getInstance().checkIfNumber(min) || !CustomValidator.getInstance().checkIfNumber(max)){
                            logger.error("Invalid data was entered.");
                        }else {
                            for (Sphere o : repo.query(new AreaSizeIsInRangeSpecification(Double.parseDouble(min),Double.parseDouble(max)))){
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
                        if(!CustomValidator.getInstance().checkIfNumber(min) || !CustomValidator.getInstance().checkIfNumber(max)){
                            logger.error("Invalid data was entered.");
                        }else {
                            for (Sphere o : repo.query(new CapacitySizeIsInRangeSpecification(Double.parseDouble(min),Double.parseDouble(max)))){
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
                        if(!CustomValidator.getInstance().checkIfNumber(min) || !CustomValidator.getInstance().checkIfNumber(max)){
                            logger.error("Invalid data was entered.");
                        }else {
                            for (Sphere o : repo.query(new CenterIsInRangeFromOriginSpecification(Double.parseDouble(min),Double.parseDouble(max)))){
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
                        repo.sortRepoByName();
                    }
                    break;
                }
                case "15":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        repo.sortRepoById();
                    }
                    break;
                }
                case "16":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        repo.sortRepoByRadius();
                    }
                    break;
                }
                case "17":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        repo.sortRepoByXCordOfCenter();
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
                        if(!CustomValidator.getInstance().checkIfNumber(id) || !CustomValidator.getInstance().checkIfNumber(newRadius)){
                            logger.error("Invalid data was entered.");
                        }else {
                            if(Double.parseDouble(newRadius)<=0){
                                logger.error("Invalid data was entered.");
                            }else {
                                for (Sphere o : repo.query(new IdSpecification(Integer.parseInt(id)))){
                                    o.attach(new SphereObserver());
                                    changeHandler.changeRadius(o,Double.parseDouble(newRadius));
                                    o.detach();
                                }
                            }
                        }
                    }
                    break;
                }
                case "19":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info(WareHouse.getInstance().showWareHouse());
                    }
                    break;
                }
                case "20":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info("Enter id: ");
                        String id = scanner.nextLine();
                        logger.info("Enter x: ");
                        String x = scanner.nextLine();
                        logger.info("Enter y: ");
                        String y = scanner.nextLine();
                        logger.info("Enter z: ");
                        String z = scanner.nextLine();
                        if(!CustomValidator.getInstance().checkIfNumber(id) || !CustomValidator.getInstance().checkIfNumber(x)||
                                !CustomValidator.getInstance().checkIfNumber(y)||!CustomValidator.getInstance().checkIfNumber(z)){
                            logger.error("Invalid data was entered.");
                        }else {
                            for (Sphere o : repo.query(new IdSpecification(Integer.parseInt(id)))){
                                o.attach(new SphereObserver());
                                changeHandler.changeXYZ(o,Double.parseDouble(x),Double.parseDouble(y),Double.parseDouble(z));
                                o.detach();
                            }
                        }
                    }
                    break;
                }
            }
        }
    }
}
