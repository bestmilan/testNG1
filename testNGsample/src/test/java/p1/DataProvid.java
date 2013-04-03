package p1;

import org.testng.annotations.*;

public class DataProvid{
	
	
	
	@DataProvider(name="local")
	public Object[][] dataP()
	{
			
		return new Object[][]{
				
				{"Tushar", "28" , "C****"},{"yatheesh" , "30 " , "C****"},{"PureVeg", "25", "C****"},{"Tycoon" , new Integer(27).toString(), "G****"}	
				
		};
		
	}
	
	
	
	
	@Test(dataProvider="local")  //note here the dataprovider startss with lower case name
	
	
				
		public void DP_using(String a, String b, String c){
			
			
			System.out.println("Printing the parameters from DS " + a+ "   " +  b+  "   " +  c);
			
		}
		
	
	
	
	
	
	
	

	
}