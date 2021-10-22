package com.makkras.task.fileop;

import com.makkras.task.exception.FileInteractionException;


public interface FileOutputer {
    void putDataIntoFile(String number, String filepath)throws FileInteractionException;
}
