package multiple_parallel;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParallelComputerTest {  

   @Test  
   public void test() {      
      Class[] cls={ParallelTest1.class,ParallelTest2.class };  

      //Parallel among classes  
      JUnitCore.runClasses(ParallelComputer.classes(), cls);  

      //Parallel among methods in a class  
      JUnitCore.runClasses(ParallelComputer.methods(), cls);  

      //Parallel all methods in all classes  
      JUnitCore.runClasses(new ParallelComputer(true, true), cls);     
   } 

   public static class ParallelTest1 {  
      @Test public void a(){
    		processit(ParallelTitleFetch(1));
    		
    	  
      }  
      @Test public void b(){
    	  
    		processit(ParallelTitleFetch(1));
    		
    	  
      }  
  
   

public static	WebDriver ParallelTitleFetch(int num)
	{
	System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	
	return driver;
	
	}
	
   

public static void processit(WebDriver driver )
{
	driver.navigate().to("http://google.com");
	String appTitle = driver.getTitle();
	System.out.println("Application title is :: "+appTitle);
	driver.quit();
	
}
   



   }  

   public static class ParallelTest2 {  
	      @Test public void a(){
	    		processit(ParallelTitleFetch(1));
	    		
	    	  
	      }  
	      @Test public void b(){
	    	  
	    		processit(ParallelTitleFetch(1));
	    		
	    	  
	      }  
	  
	   

	public static	WebDriver ParallelTitleFetch(int num)
		{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		return driver;
		
		}
		
	   

	public static void processit(WebDriver driver )
	{
		driver.navigate().to("http://google.com");
		String appTitle = driver.getTitle();
		System.out.println("Application title is :: "+appTitle);
		driver.quit();
		
	}
	   



	   }  
} 