package DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read {
	public static void main(String[] args) throws IOException {
		File loc = new File("C:\\Users\\admin\\BigW\\ProjectBigW\\ProjectBigW\\DataDriven\\BigW.xlsx");
		FileInputStream stream = new FileInputStream(loc);
		Workbook w= new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Sheet1");
		for (int i = 0; i <s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(i);
			for (int j = 0; j <r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				int type = c.getCellType();
				if (type==1) {
					String stringCellValue = c.getStringCellValue();
					System.out.println(stringCellValue);
			}else if (type==0) {
				if (DateUtil.isCellDateFormatted(c)) {
					Date dateCellValue = c.getDateCellValue();
					SimpleDateFormat sim = new SimpleDateFormat("dd-MMM-yy");
					String format = sim.format(dateCellValue);
					System.out.println(format);
				}else {
					double numericCellValue = c.getNumericCellValue();
					long l = (long)numericCellValue;
					String valueOf = String.valueOf(l);
					System.out.println(valueOf);
				}
			}
			}
		}
	}
}