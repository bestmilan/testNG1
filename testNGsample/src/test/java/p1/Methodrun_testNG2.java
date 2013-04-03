
package p1;


import java.lang.annotation.Retention;

import org.testng.annotations.*;




public class Methodrun_testNG2{
	
	
	
	//So execution of annotations as per the hierarchy/priority
	
/*	@BeforeSuite : -- This will be first methods to run.. all the methods from all the classes will be looked for these methods and those wil be run
	@BeforeClass -- for every test class first methods to run will be these methods
	@BeforeTest-- This will be execute once in a file before the very first test method
	@BeforeGroups(groups={"a"}) -- These will be run for every test method which belong to a test groups sepecified in this annotation
	@BeforeMethod()	-- This will be executed before every test method  
	
	
	Firstly ALL suite annotations methods will be executed ONCE..then all methods of @BeforeClass will be executed ONCE for a test class
	then all methods of @BeforeTest will be executed ONCE before any test method, then if any BeforeGroups if any for every test method of group
	then @BeforeMethod() before every test method.
	
	*/
	
	
	
	
	
	
	
	
	
	
	/*
	@BeforeClass
	
	public void beforeclass_Methodrun_testNG2()
	{
		
		System.out.println("Before class method for the class name Methodrun_testNG2");
		
	}
	
@AfterClass
	
	public void afterclass_Methodrun_testNG2()
	{
		
		System.out.println("After class method for the class name Methodrun_testNG2");
		
	}
	*/

	
	
@BeforeTest
	
	public void beforeclass_Methodrun_testNG2()
	{
		
		System.out.println("Before test method for the class name Methodrun_testNG2");
		
	}
	
@AfterTest
	
	public void afterclass_Methodrun_testNG2()
	{
		
		System.out.println("After test method for the class name Methodrun_testNG2");
		
	}
	
	
	
	
	

	@BeforeGroups({"A"})
	
	public void bg1(){
		
		System.out.println("************ Before Group A called");
	}
	
	
@AfterGroups({"A"})
	
	public void bg2(){
		
		System.out.println("************ After Group A called");
	}
	
//@BeforeMethod (groups = {"C"})  This is illegal.. but dont give any compile/run time error.. we have BeforeGroups for this

	@BeforeMethod ()
	public void BeforeMethod_Methodrun_testNG2C()
{
	
	System.out.println("Before Method annotation for the class name Methodrun_testNG2 and groups \"C\"");
	
}

@AfterMethod ()
public void AfterMethod_Methodrun_testNG2C()
{
	
	System.out.println("After Method annotation for the class name Methodrun_testNG2 and groups \"C\"");

	
}

	
	
@BeforeGroups (groups = {"C"})
public void BeforeMethod_Methodrun_testNG2()
{
	
	System.out.println("************ Before Group C called");
	
}

@AfterGroups (groups = {"C"})
public void AfterMethod_Methodrun_testNG2()
{
	
	System.out.println("************ After Group C called");
	
}


	
	@Test
	public void met5(){
		
		
		System.out.println("method 5 called");
	}
	
	
	@Test(groups ={"B"})
public void met6(){
		
		
		System.out.println("method 6 called");
	}
	
	
	@Test(groups = { "A", "B", "C" })
	public void met8(){
			
			
			System.out.println("method 8 called");
		}
	
	@Test
	public void met7(){
			
			
			System.out.println("method 7 called");
			//return 10;
		}
	
	
	@BeforeSuite
	public void Suitestart(){
		
		System.out.println("**************Before suite method of second  Methodrun_testNG2 ");
		
		
	}
	
	
	
	
	@AfterSuite
	public void SuiteEND(){
		
		System.out.println("**************After suite method of second  Methodrun_testNG2 ");
		
		
	}
	
	//depends on ..like signout shoudl be only after sign in
	@Test(dependsOnMethods={"met7"}, alwaysRun=true )		//default alwaysRun = false
	
	public void dependentmethod(){
		
		System.out.println("******** The current method run after the met 7 dependsOnMethods called");
		
	}
	
	
	
}