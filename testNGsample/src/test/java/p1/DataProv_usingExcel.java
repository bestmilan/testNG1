package p1;
import java.io.File;

import jxl.Workbook;
import jxl.Cell;
import jxl.Sheet;

import org.testng.annotations.*;



//jxl.jar for reading/writing excel sheets

public class DataProv_usingExcel{
	
	
		
	
	
	
	
	
		public String[][] getTableArray(String xlFilePath, String sheetName, String tableName){
	        String[][] tabArray=null;
	        try{
	            Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
	            Sheet sheet = workbook.getSheet(sheetName);
	            int startRow,startCol, endRow, endCol,ci,cj;
	            Cell tableStart=sheet.findCell(tableName);
	            startRow=tableStart.getRow();
	            startCol=tableStart.getColumn();

	            Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                               

	            endRow=tableEnd.getRow();
	            endCol=tableEnd.getColumn();
	            System.out.println("startRow="+startRow+", endRow="+endRow+", " +
	                    "startCol="+startCol+", endCol="+endCol);
	            tabArray=new String[endRow-startRow-1][endCol-startCol-1];
	            ci=0;

	            for (int i=startRow+1;i<endRow;i++,ci++){
	                cj=0;
	                for (int j=startCol+1;j<endCol;j++,cj++){
	                    tabArray[ci][cj]=sheet.getCell(j,i).getContents();
	                }
	            }
	        }
	        catch (Exception e)    {
	            
	        	e.printStackTrace();
	        	System.out.println("error in getTableArray()");
	        }

	        return(tabArray);
	    }
		
		
	
	
	
	@DataProvider(name= "DP using jxlJAR")
	public Object[][] sss()
		{
		String xlFilePath="ExcelRepo\\woo.xls";
		String sheetName="Sheet1";
		String tableName="XX2";
			
		return getTableArray(xlFilePath, sheetName, tableName);
	}
	
	
	
	@Test(dataProvider="DP using jxlJAR")
	public void exec(String Table1, String Name, String Age, String Sex )
	
	{
		
		
		System.out.println("table named Details1 details are " + Table1  +  " "+Name +  " "+ Age +  " "+ Sex );
		
		
		
	}
	
	
	
	
	
	
	
}

