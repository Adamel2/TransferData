package com.sendinfo.readData;
/**
 * @author Eldda Adham
 */

import java.io.*;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;


public class ReadExcel implements typeFiles {

    /**
     * @// TODO: 10/6/19
     */
    private ArrayList<ArrayList<String>> tableSheet = new ArrayList<>();
    private int noOfColumns;

    public ReadExcel(String nameFile) throws IOException, InvalidFormatException {
        readData(nameFile);
    }

    public void readData(String nameFile) throws IOException, InvalidFormatException {
        try {
            nameFile += ".xlsx";
            InputStream inp = new FileInputStream(nameFile);
            int ctr = 0;
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            Row row = null;
            Cell cell = null;
            this.noOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();
            boolean isNull = false;
            for (int i = 0; i <= this.noOfColumns; i++) {
                this.tableSheet.add(new ArrayList<String>());
            }
            for (int i = 0; i < this.noOfColumns; i++) {

                do {
                    try {
                        row = sheet.getRow(ctr);
                        cell = row.getCell(i);
                        this.tableSheet.get(i).add(cell.toString());
                        ctr++;
                    } catch (Exception e) {
                        isNull = true;
                    }
                } while (isNull != true);

                ctr = 0;
                isNull = false;
                row = null;
                cell = null;
            }

            for (int i = 0; i < noOfColumns; i++) {
                this.tableSheet.get(i).remove(0);
            }
            inp.close();

        } catch (Exception e) {
            System.out.print(e);

        }
    }

    public ArrayList<String> outColumn(int NumberColumn) {
        ArrayList<String> dataColumn = new ArrayList<String>();

        try {
            for (int i = 0; i < this.tableSheet.get(NumberColumn - 1).size(); i++) {
                dataColumn.add(this.tableSheet.get(NumberColumn - 1).get(i));
            }
            return dataColumn;
        } catch (Exception e) {
            System.out.print(e);
        }
        return dataColumn;

    }


    public ArrayList<ArrayList<String>> getTableSheet() {
        return tableSheet;
    }
}





