package multiple_parallel_complex;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.apache.commons.io.FileUtils;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class ParallelComputerTest {

	@Test
	public void test() {
		Class[] cls = { ParallelTest1.class, ParallelTest2.class };

		/*
		 * //Parallel among classes
		 * JUnitCore.runClasses(ParallelComputer.classes(), cls);
		 * 
		 * //Parallel among methods in a class
		 * JUnitCore.runClasses(ParallelComputer.methods(), cls);
		 */
		// Parallel all methods in all classes
		JUnitCore.runClasses(new ParallelComputer(true, true), cls);
	}

	
	
	
	public static class ParallelTest1 {

		private ScreenRecorder screenRecorder;

		@Test
		public void a() throws IOException {
			processit(ParallelTitleFetch(1));

		}

		@Test
		public void b() throws Exception {

			ParallelTest1 videoReord = new ParallelTest1();
			videoReord.startRecording();

			processit2(ParallelTitleFetch(1));
			videoReord.stopRecording();

		}

		public static WebDriver ParallelTitleFetch(int num) {
			System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			return driver;

		}

		public void startRecording() throws Exception {

			File file = new File("D:\\Videos");

			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int width = screenSize.width;
			int height = screenSize.height;

			Rectangle captureSize = new Rectangle(0, 0, width, height);

			GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
					.getDefaultConfiguration();

			this.screenRecorder = new SpecializedScreenRecorder(gc, captureSize,
					new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
					new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
							CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
							Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
					new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
					null, file, "MyVideo");
			this.screenRecorder.start();

		}

		public void stopRecording() throws Exception {
			this.screenRecorder.stop();
		}

		public static void processit(WebDriver driver) throws IOException {


			String baseUrl = "http://my.sjsu.edu/";
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(baseUrl + "/");
			driver.findElement(By.cssSelector("a.btn.btn-cyan")).click();
			driver.findElement(By.id("user-signin")).clear();
			driver.findElement(By.id("user-signin")).sendKeys("011468730");
			driver.findElement(By.id("pass-signin")).sendKeys("Systempass8");
			driver.findElement(By.id("signin-button")).click();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			try {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(".//*[@id='ext-gen36']/table/tbody/tr[1]/td[1]/div/div")));
			}

			catch (Exception e) {

			}
			driver.findElement(By.xpath(".//*[@id='pthdr2logout']/span")).click();

			try {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(".//*[@id='ext-gen36']/table/tbody/tr[1]/td[1]/div/div")));
			}

			catch (Exception e) {

			}

			
			File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile1, new File("screenshot1.png"));

			
			driver.close();

		

		
			
		}

		public static void processit2(WebDriver driver) throws IOException {
			String baseUrl = "http://my.sjsu.edu/";
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(baseUrl + "/");
			driver.findElement(By.cssSelector("a.btn.btn-cyan")).click();
			driver.findElement(By.id("user-signin")).clear();
			driver.findElement(By.id("user-signin")).sendKeys("011468730");
			driver.findElement(By.id("pass-signin")).sendKeys("Systempass8");
			driver.findElement(By.id("signin-button")).click();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			try {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(".//*[@id='ext-gen36']/table/tbody/tr[1]/td[1]/div/div")));
			}

			catch (Exception e) {

			}
			driver.findElement(By.xpath(".//*[@id='pthdr2logout']/span")).click();

			try {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(".//*[@id='ext-gen36']/table/tbody/tr[1]/td[1]/div/div")));
			}

			catch (Exception e) {

			}

			File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile1, new File("screenshot2.png"));

			
			driver.close();

		}

	}
	
	
	
	
	
	
	
	

	public static class ParallelTest2 {
		@Test
		public void a() throws IOException {
			processit(ParallelTitleFetch(1));

		}

		@Test
		public void b() throws Exception {

			processit2(ParallelTitleFetch(1));

		}

		public static WebDriver ParallelTitleFetch(int num) {
			System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			return driver;

		}

		public static void processit(WebDriver driver) throws IOException {
			String baseUrl = "http://my.sjsu.edu/";
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(baseUrl + "/");
			driver.findElement(By.cssSelector("a.btn.btn-cyan")).click();
			driver.findElement(By.id("user-signin")).clear();
			driver.findElement(By.id("user-signin")).sendKeys("011468730");
			driver.findElement(By.id("pass-signin")).sendKeys("Systempass8");
			driver.findElement(By.id("signin-button")).click();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			try {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(".//*[@id='ext-gen36']/table/tbody/tr[1]/td[1]/div/div")));
			}

			catch (Exception e) {

			}
			driver.findElement(By.xpath(".//*[@id='pthdr2logout']/span")).click();

			try {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(".//*[@id='ext-gen36']/table/tbody/tr[1]/td[1]/div/div")));
			}

			catch (Exception e) {

			}

			
			File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile1, new File("screenshot3.png"));

			
			driver.close();

		}

		public static void processit2(WebDriver driver) throws IOException {
			String baseUrl = "http://my.sjsu.edu/";
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(baseUrl + "/");
			driver.findElement(By.cssSelector("a.btn.btn-cyan")).click();
			driver.findElement(By.id("user-signin")).clear();
			driver.findElement(By.id("user-signin")).sendKeys("011468730");
			driver.findElement(By.id("pass-signin")).sendKeys("Systempass8");
			driver.findElement(By.id("signin-button")).click();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			try {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(".//*[@id='ext-gen36']/table/tbody/tr[1]/td[1]/div/div")));
			}

			catch (Exception e) {

			}
			driver.findElement(By.xpath(".//*[@id='pthdr2logout']/span")).click();

			try {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(".//*[@id='ext-gen36']/table/tbody/tr[1]/td[1]/div/div")));
			}

			catch (Exception e) {

			}
			
			File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile1, new File("screenshot4.png"));

			

			driver.close();

		}

	}

}
