package multiple;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTitleFetch {
	
	public static void main(String...args) {
		
	
	for (int i=0;i<=4;i++)
	{
		processit(ParallelTitleFetch(i));
		
	}
		
	
	
	
	
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



