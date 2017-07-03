package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadUtility 
{
	FileInputStream fileInput = null;
	static XSSFWorkbook ExcelWBook;
	static XSSFSheet ExcelSheet;
	static XSSFCell ExcelCell;
	static String ExcelFilePath;// = PropertiesFile.ExcelFilePath;
	static String ExcelFile;// = PropertiesFile.ExcelFile;
	static String XcelSheet;// = PropertiesFile.ExcelSheet;
	static FileInputStream ExcelFileStream = null;
	private String searchString = null;
	
	public void SetExcelFile(String excelFilePath, String excelFile, String excelSheet, String searchPhrase)
	{
		ExcelFilePath = excelFilePath;
		ExcelFile = excelFile;
		XcelSheet = excelSheet;
		searchString = searchPhrase;
		XSSFCell[] Cells = GetBorderCells();
		XSSFCell beginCell = Cells[0];
		XSSFCell endCell = Cells[1];
		String TestData[][] = null;
		XSSFCell[][] DataCells = null;
		
		
		try 
		{
			ExcelFileStream = new FileInputStream(ExcelFilePath + ExcelFile);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try {
			ExcelWBook = new XSSFWorkbook(ExcelFileStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExcelSheet = ExcelWBook.getSheet(XcelSheet);
		int firstRow = beginCell.getRowIndex() + 1;
		int firstCol = beginCell.getColumnIndex() + 1;
		int lastRow = endCell.getRowIndex() - 1;
		int lastCol = endCell.getColumnIndex() - 1;
		
		for(int i = firstRow; i <= lastRow; i++)
		{
			for(int j = firstCol; j<= lastCol; j++)
			{
				DataCells[i][j] = ExcelSheet.getRow(i).getCell(j);
				TestData[i][j] = DataCells[i][j].toString();
			}
		}
	}
	
	private XSSFCell[] GetBorderCells()
	{
		XSSFCell[] Cells = new XSSFCell[2];
		XSSFCell beginCell = null, 
		endCell = null;
		Cells[0] = beginCell;
		Cells[1] = endCell;
		String pos = "begin";
		
		for(Row row: ExcelSheet)
		{
			for(Cell cell: row)
			{
				if(searchString.equalsIgnoreCase("data"))
				{
					if(pos.equalsIgnoreCase("begin"))
					{
						beginCell = (XSSFCell) cell;
						pos = "end";
					}
					else
					{
						endCell = (XSSFCell) cell;
					}
				}

			}
		}
		return Cells;
		
	}
	
}
