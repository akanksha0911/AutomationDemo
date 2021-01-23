package basic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BasicTitleFetch {
	
	public static void main(String...args) {
		
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://google.com");
		String appTitle = driver.getTitle();
		System.out.println("Application title is :: "+appTitle);
		driver.quit();
	}

}