package DataDriven;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write {
	public static void main(String[] args) throws IOException {
		File loc = new File("C:\\Users\\admin\\BigW\\ProjectBigW\\ProjectBigW\\DataDriven\\write.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Louis");
		Row row = s.createRow(2);
		Cell c = row.createCell(2);
		c.setCellValue("louis");
		FileOutputStream stream = new FileOutputStream(loc);
		w.write(stream);
		System.out.println("***END***");
	
	}

}