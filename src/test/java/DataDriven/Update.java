package DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Update {
public static void main(String[] args) throws IOException {
	File loc = new File("C:\\Users\\admin\\BigW\\ProjectBigW\\ProjectBigW\\DataDriven\\write.xlsx");
	FileInputStream stream = new FileInputStream(loc);
	Workbook w = new XSSFWorkbook(stream);
	Sheet s = w.getSheet("Louis");
	Row r = s.getRow(2);
	Cell c = r.getCell(2);
	String s1 = c.getStringCellValue();	
	if (s1.equalsIgnoreCase("louis")) {
		c.setCellValue("xavier");
	}
	FileOutputStream o = new FileOutputStream(loc);
	w.write(o);
	System.out.println("***END***");
}
}