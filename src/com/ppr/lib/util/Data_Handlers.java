package com.ppr.lib.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Data_Handlers {
	public static String GetDataFromProperties(String FileName,String key) {
		String data=null;
	try{
		File f=new File("./Config_Folder/"+FileName+".properties");
	FileInputStream FIS=new FileInputStream(f);
		Properties prop=new Properties();
		prop.load(FIS);
		data=prop.get(key).toString();
	}
	catch(Exception E){
		E.printStackTrace();	
	}
	return data;
	}
	
	public static void SetDatatoProperties(String FileName,String key,String Value,String Msg) {
	try{
		File f=new File("./Config_Folder/"+FileName+".properties");
	    FileInputStream FIS=new FileInputStream(f);
		Properties prop=new Properties();
		prop.load(FIS);
		prop.setProperty(key, Value);
		FileOutputStream FOS= new FileOutputStream(f);
		prop.store(FOS,Msg);
	}
	catch(Exception E){
		E.printStackTrace();	
	}
	}
	public static String GetDataFromExcel(String Filename,String SheetName,int Row,int Cell) {
		String data=null;
		try {
			File f=new File("./Test_Data/"+Filename+".xlsx");
			FileInputStream FIS=new FileInputStream(f);
			Workbook wb= WorkbookFactory.create(FIS);
			Sheet st=wb.getSheet(SheetName);
			Row R=st.getRow(Row);
			Cell C=R.getCell(Cell);
			data=C.toString();
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		return data;
	}
	public static void SetDataToExcel(String Filename,String SheetName,int Row,int Cell,String data) {
		try {
			File f=new File("./Test_Data/"+Filename+".xlsx");
			FileInputStream FIS=new FileInputStream(f);
			Workbook wb= WorkbookFactory.create(FIS);
			Sheet st=wb.getSheet(SheetName);
			Row R=st.getRow(Row);
			Cell C=R.getCell(Cell);
			C.setCellValue(data);
			FileOutputStream FOS= new FileOutputStream(f);
			wb.write(FOS);
		}
		catch(Exception E) {
			E.printStackTrace();
		}
	}
	}



