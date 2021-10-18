package com.makkras.validator.impl;

import com.makkras.validator.DataValidator;

public class CustomValidator implements DataValidator {
private final static String NUMBER_PATTERN = "-?\\d+(\\.\\d+)?";
private static CustomValidator instance;
private CustomValidator(){}
public static CustomValidator getInstance(){
    if(instance ==null){
        instance = new CustomValidator();
    }
    return instance;
}
public boolean checkIfNumber(String string){
    return string.matches(NUMBER_PATTERN);
}
}
