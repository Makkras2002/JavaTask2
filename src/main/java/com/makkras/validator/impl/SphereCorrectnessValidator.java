package com.makkras.validator.impl;
import com.makkras.validator.SphereValidator;

public class SphereCorrectnessValidator implements SphereValidator {
    public boolean checkIfSphere(String[] rawData){
        int rawDataCounter =2;
        boolean isGoodLine = true;
        while (rawDataCounter <rawData.length){
            if(!CustomValidator.getInstance().checkIfNumber(rawData[rawDataCounter])){
                isGoodLine = false;
                break;
            }
            rawDataCounter++;
        }
        if(isGoodLine){
            if(rawData.length != 6 || Double.parseDouble(rawData[5]) <=0 || !CustomValidator.getInstance().checkIfNumber(rawData[0])){
                isGoodLine =false;
            }
        }
        return isGoodLine;
    }
}
