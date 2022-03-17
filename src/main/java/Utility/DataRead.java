package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataRead 
{
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	static FileInputStream inputFile;
	static Properties pro;
	
	public static Properties readPropertiesFile() throws IOException
	{
		inputFile=new FileInputStream("TestData/SingleValueData.properties");
		pro=new Properties();
		pro.load(inputFile);
		return pro;
	}
	
	public HashMap<String,String> readExcelFile(String userName) throws IOException
	{
		inputFile=new FileInputStream("TestData/UserData.xlsx");
		workbook=new XSSFWorkbook(inputFile);
		sheet=workbook.getSheetAt(0);
		int totalRow=sheet.getLastRowNum();
		int totalColumns=sheet.getRow(0).getLastCellNum();
		System.out.println(totalRow);
		System.out.println(totalColumns);
		
		HashMap<String,String> userData=new HashMap<>();
		
		for(int nameColumn=1;nameColumn<=totalRow;nameColumn++)
		{
			String name=sheet.getRow(nameColumn).getCell(0).toString();
			if(name.equals(userName))
			{
				String emailID=sheet.getRow(nameColumn).getCell(1).toString();
				userData.put("email", emailID);
				String pwd=sheet.getRow(nameColumn).getCell(2).toString();
				userData.put("password", pwd);
			}
		
		}
		return userData;
	}
	
	
	}
	

