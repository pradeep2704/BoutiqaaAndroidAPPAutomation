package Boutiqaat.Boutiqaat;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass extends AppuimServer {
	
	
	static DesiredCapabilities cap;
	//RemoteWebDriver driver;
	//AndroidDriver driver;
	AndroidDriver driver;


  
	public static AndroidDriver setup(AndroidDriver driver, String url)
			throws Exception {
		AppuimServer Aserver = new AppuimServer();
		Aserver.startServer();
		
		//File file = new File("D:\\personal\\prdeep docs\\prdeep docs\\automation\\automation\\VShopp.apk");
		File file = new File("C:\\Users\\pradeep\\Desktop\\APK\\ES\\appbeta");
		cap = new DesiredCapabilities();
		cap.setCapability("app", file.getAbsolutePath());
		cap.setCapability("platformName", "Android");
		cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability("platformVersion", "6.0");
		cap.setCapability("deviceName", "Lenovo");
		//cap.setCapability("appPackage", "vitaminshoppe.consumerapp");
		//cap.setCapability("appActivity","vitaminshoppe.consumerapp.LoadingActivity");
		cap.setCapability("appPackage", "com.lezasolutions.boutiqaat");
		cap.setCapability("appActivity",".ui.home.HomeActivity t2546");
		// driver = new AndroidDriver(new URL("127.0.0.1:4723/wd/hub"), cap);
		driver = new AndroidDriver(new URL(url), cap);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		// RemoteWebDriver driver = new RemoteWebDriver(new
		// URL("http://127.0.0.2:4723/wd/hub"),cap);
		return driver;
	}
	@Test
	public void testServer() {
		System.err.println("The URL is :"+ service.getUrl().toString());
		System.err.println("Is service Runing  ::"+service.isRunning());
		//service.sendOutputTo(New FileOutputStream("E:/Logfile/logFile.txt"));
		
		

	}
	public static String tearDown(AndroidDriver driver) {
		AppuimServer Aserver = new AppuimServer();
		Aserver.stopServer();
		driver.quit();
		return null;
		
	}

	public static String sendKeys(AndroidDriver driver, String LocatorType,
			String LocatorValue, String Param1) throws Exception {

		switch (LocatorType) {

		case "id":
			driver.findElement(By.id(LocatorValue)).sendKeys(Param1);
			break;
		case "xpath":
			driver.findElement(By.xpath(LocatorValue)).sendKeys(Param1);
			break;
		case "linkText":
			driver.findElement(By.linkText(LocatorValue)).sendKeys(Param1);
			break;
		}
		Thread.sleep(3000);
		return null;

	}

	public static String clickElement(AndroidDriver driver,
			String LocatorType, String LocatorValue, String Param1)
			throws Exception {
		switch (LocatorType) {
		case "id":
			driver.findElement(By.id(LocatorValue)).click();
			break;
		case "xpath":
			driver.findElement(By.xpath(LocatorValue)).click();
			break;
		case "linkText":
			driver.findElement(By.linkText(LocatorValue)).click();
			break;
			
		}
		Thread.sleep(3000);
		return null;

	}

}
