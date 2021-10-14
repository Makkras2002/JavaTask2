package com.makkras.validator.impl;

import com.makkras.validator.DataValidator;

public class CustomValidator implements DataValidator {
private final static String NUMBER_PATTERN = "-?\\d+(\\.\\d+)?";
private static CustomValidator INSTANCE;
private CustomValidator(){}
public static CustomValidator getInstance(){
    if(INSTANCE==null){
        INSTANCE = new CustomValidator();
    }
    return INSTANCE;
}
public boolean checkIfNumber(String string){
    return string.matches(NUMBER_PATTERN);
}
}
