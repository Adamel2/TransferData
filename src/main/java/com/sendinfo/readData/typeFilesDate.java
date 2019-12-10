package com.sendinfo.readData;
/**
 * @author Eldda Adham
 */

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public interface typeFilesDate {
    /**
     * @// TODO: 10/6/19
     */
    ArrayList<Calendar> readDataTypeTime(String nameFile, int noOfColumns) throws IOException, InvalidFormatException;
}