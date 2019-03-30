import java.util.ArrayList;
import java.util.Scanner; 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
public class Attendance{
  public Attendance(ArrayList<Member> memberList){
    try{
    XSSFWorkbook workbook=new XSSFWorkbook();
    FileOutputStream out= new FileOutputStream(new File("H:/Xcel.xlsx"));
    XSSFSheet Spreadsheet=workbook.createSheet("itriedhard");
    XSSFRow row = Spreadsheet.createRow((short) 2);
      row.createCell(0).setCellValue("Osis");
      row.createCell(1).setCellValue("Status");
    workbook.write(out);
    for (int i = 0; i<memberList.size(); i++){
      Integer osis = memberList.get(i).getID();
      XSSFRow row1 = Spreadsheet.createRow((short) i+3);
      row.createCell(0).setCellValue(osis);
      row.createCell(1).setCellValue("present");
    }
    out.close();
    }
    catch(Exception e){
      System.out.println(e);
  }
}
}