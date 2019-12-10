import com.sendinfo.TransferData;
import com.sendinfo.readData.ReadExcel;
import com.sendinfo.readData.ReadExcelDate;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author adhameldda
 */
public class Main {
    public static void getExpenses() throws ClassNotFoundException, SQLException {
        ArrayList<Date> dates = new ArrayList<>();
        try {
        String myDriver = "org.gjt.mm.mysql.Driver";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection("jdbc:mysql://*****", "root", "***");
        ArrayList<Object> expenses = new ArrayList<Object>();

            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM data4");

            while(result.next()) {
                dates.add(result.getDate(12));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i <dates.size() ; i++) {

            System.out.println(dates.get(i).toString());
        }
    }


        public static void main(String[] args) throws IOException, InvalidFormatException, SQLException, ClassNotFoundException {
            TransferData transferData = new TransferData();
            transferData.sendDataSecondFile();





    }
}
