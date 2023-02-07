package generics_Utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility 
{
	public String getExcelData(String SheetName,int RowName, int Cell) throws Throwable
	{
		//fetching data from the excel sheet
		FileInputStream fis1 = new FileInputStream("./src/test/resources/VtigerData.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		 String value = book.getSheet(SheetName).getRow(RowName).getCell(Cell).getStringCellValue();
		return value;

	}
}
