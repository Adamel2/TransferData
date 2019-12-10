package com.sendinfo.readData;

/**
 * @author Eldda Adham
 */

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.IOException;
import java.util.ArrayList;
public class ReadFile {
    /**
     * @// TODO: 10/6/19
     */
    private ReadExcel readExcel;
    public ReadFile(String nameFile) throws IOException, InvalidFormatException {
        this.readExcel = new ReadExcel(nameFile);
    }
    public ArrayList<String> ReadColumn(int numberColumn){



        return this.readExcel.outColumn(numberColumn);
    }
}
