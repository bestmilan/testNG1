
package p1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;




public class Methodrun_testNG{
	
	
	@Test
	public void met1(){
		
		
		System.out.println("method 1 called");
	}
	
	
	@Test
public void met2(){
		
		
		System.out.println("method 2 called");
	}
	
	
	@Test
	public void met4(){
			
			
			System.out.println("method 4 called");
		}
	
	@Test
	public void met3(){
			
			
			System.out.println("method 3 called");
		}
	
	@BeforeSuite
	public void Suitestart(){
		
		System.out.println("**************Before suite method of first Methodrun_testNG ");
		
		
	}
	
	
	@AfterSuite
	public void SuiteEND(){
		
		System.out.println("**************After suite method of first Methodrun_testNG ");
		
		
	}
	
	
}