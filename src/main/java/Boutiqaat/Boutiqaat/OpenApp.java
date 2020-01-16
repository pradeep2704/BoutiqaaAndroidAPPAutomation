package Boutiqaat.Boutiqaat;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class OpenApp {

	private static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException {
		File file = new File("C:\\Users\\pradeep\\Desktop\\APK\betaApp.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability("deviceName", "lenovo");
		cap.setCapability("plateformVersion", "6.0");
		cap.setCapability("plateformName", "Android");
		cap.setCapability("appPackage", "");
		cap.setCapability("appActivity", "");
		cap.setCapability("appPackage", "com.lezasolutions.boutiqaat");
		cap.setCapability("appActivity",".ui.home.HomeActivity t2546");
		//driver = new AndroidDriver(new URL("http://127.0.0.1:4727/wd/hub"),cap);
		driver = new AndroidDriver(new URL("https://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	

	}

}
