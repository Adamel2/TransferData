package com.sendinfo;

import com.sendinfo.readData.ReadExcel;
import com.sendinfo.readData.ReadExcelDate;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author adhameldda
 */
public class TransferData implements Factory{


    @Override
    public void sendDataFirstFile() {
        try
        {

            int idKey =0;
            ReadExcel readExcel = new ReadExcel("thirdFile");

            ArrayList<ArrayList<String>> newData= new ArrayList<>();

            newData = readExcel.getTableSheet();


            String myDriver = "org.gjt.mm.mysql.Driver";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection("jdbc:mysql://", "", "");

            String query = " insert into data3 (company,clusternumber,sku,linenumber,direction,alternative,arranging,stationname,timetrip,let_,long_,citycode,cityname,status,areacode)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            for (int i = 0; i <newData.get(1).size() ; i++) {
                PreparedStatement preparedStmt = conn.prepareStatement(query);

                preparedStmt.setString(1, newData.get(0).get(i));
                preparedStmt.setString(2, newData.get(1).get(i));
                preparedStmt.setString(3, newData.get(5).get(i));
                preparedStmt.setString(4, newData.get(6).get(i));
                preparedStmt.setString(5, newData.get(7).get(i));
                preparedStmt.setString(6,newData.get(8).get(i) );
                preparedStmt.setString(7, newData.get(10).get(i));
                preparedStmt.setString(8, newData.get(12).get(i));
                preparedStmt.setString(9, newData.get(17).get(i));
                preparedStmt.setString(10, newData.get(20).get(i));
                preparedStmt.setString(11, newData.get(21).get(i));
                preparedStmt.setString(12, newData.get(22).get(i));
                preparedStmt.setString(13, newData.get(23).get(i));
                preparedStmt.setString(14, newData.get(26).get(i));
                preparedStmt.setString(15, newData.get(27).get(i));

                preparedStmt.execute();

                idKey++;
            }
            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        System.out.println("Your Data in SQL Project");

    }

    @Override
    public void sendDataSecondFile() throws IOException, InvalidFormatException {
        try
        {
            ReadExcel readExcel = new ReadExcel("fourthFile");
            ReadExcelDate readExcelDate = new ReadExcelDate();

            ArrayList<Calendar> calendars = new ArrayList<Calendar>();
            calendars = readExcelDate.readDataTypeTime("fourthFile",11);
            ArrayList<ArrayList<String>> newData= new ArrayList<>();
            newData = readExcel.getTableSheet();

            System.out.println(calendars.size());



            String myDriver = "org.gjt.mm.mysql.Driver";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection("jdbc:mysql://", "", "");

            String query = " insert into data4 (company,clusternumber,cluster,subcluster,region,sku,linenumber,direction,alternative,signage,leavingtime)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?)";//cluster


             for (int i = 0; i <newData.get(1).size() ; i++) {
                PreparedStatement preparedStmt = conn.prepareStatement(query);



                preparedStmt.setString(1, newData.get(0).get(i));
                preparedStmt.setString(2, newData.get(1).get(i));
                preparedStmt.setString(3, newData.get(2).get(i));
                preparedStmt.setString(4, newData.get(3).get(i));
                preparedStmt.setString(5, newData.get(4).get(i));
                preparedStmt.setString(6, newData.get(6).get(i));
                preparedStmt.setString(7, newData.get(7).get(i));
                preparedStmt.setString(8, newData.get(8).get(i));
                preparedStmt.setString(9, newData.get(9).get(i));
                preparedStmt.setString(10, newData.get(10).get(i));
                preparedStmt.setTime(11, new java.sql.Time(calendars.get(i).getTimeInMillis()));
                preparedStmt.execute();
            }
            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        System.out.println("Your Data in SQL Project");

    }

    }

