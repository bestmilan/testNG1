package p1;

import org.testng.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Parameter{			//This class must be public else other package testng can not access it
	
	
	@Parameters({"param1"})			//it could be passed to any annotation method..even for before and after methods
	@Test
	public void test1(String myname){
		
		
		Assert.assertTrue(myname.equals("Parveen"));
		
	}
	
	
	
}