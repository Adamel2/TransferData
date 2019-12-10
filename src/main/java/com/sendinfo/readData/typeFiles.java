package com.sendinfo.readData;
/**
 * @author Eldda Adham
 */

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public interface typeFiles {
    /**
     * @// TODO: 10/6/19
     */
    public void readData(String nameFile) throws IOException, InvalidFormatException;
}
