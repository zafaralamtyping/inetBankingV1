package com.inetbanking.utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class XLUtils {
	ArrayList<String> userName = new ArrayList<String>();
	ArrayList<String> password = new ArrayList<String>();
	String[] dataDriven ;
	
	@Test
	public Object[][] dataDrivenExcel() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\admin\\work\\inetBankingV1\\src\\test\\java\\com\\inetbanking\\testData\\LoginData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		int numberOfSheets = workBook.getNumberOfSheets();
		for(int i=0; i<numberOfSheets; i++) {
			if(workBook.getSheetName(i).equals("Sheet1")) {
				XSSFSheet sheet = workBook.getSheetAt(i);
				Iterator<Row> rows= sheet.iterator();
				rows.next();
				while(rows.hasNext()) {
					Iterator<Cell> cells = rows.next().cellIterator();
					userName.add(cells.next().getStringCellValue());
					password.add(cells.next().getStringCellValue());
				} //rows while
				
			} // main if loop
		}// main for loop
		
		String[] userNameArray = new String[userName.size()];
		for(int i=0; i<userName.size(); i++) {
			userNameArray[i] = userName.get(i);
		}
		
		String[] passwordArray = new String[password.size()];
		for(int i=0; i<password.size(); i++) {
			passwordArray[i] = password.get(i);
		}
		
		Object obj[][] = new Object[userNameArray.length][2];
		for (int i = 0; i < userNameArray.length; i++) {
		    obj[i][0] = userNameArray[i];
		    obj[i][1] = passwordArray[i];
		}
		
//		for(int i=0; i<userNameArray.length; i++) {
//			for(int j=0; j<2; j++) {
//				System.out.print(obj[i][j] + "  ");
//			}
//			System.out.println();
//		}
		return obj;
	}
	
	

}
