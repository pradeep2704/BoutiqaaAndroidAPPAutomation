package Boutiqaat.Boutiqaat;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public  class AppuimServer {
	
	static String NodePath = "C:/Program Files/nodejs/node.exe";
	static String AppiumMainJS_Path ="C:\\Users\\pradeep\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
	static AppiumDriverLocalService service ;
	static SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	@BeforeTest()
	public void startServer() throws InterruptedException {
		
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(NodePath)).withAppiumJS(new File(AppiumMainJS_Path))
				.withIPAddress("127.0.0.1")
				.usingPort(4728)
				.withLogFile(new File("E:/Logfile/logFile.txt")));
		
		System.out.println("Starting the Appium Server.........."+"\n"+df.format(new Date())+"\n---------------------------------");
		service.start();
		Thread.sleep(10000);

	}
	@Test
	public void testServer() {
		System.err.println("The URL is :"+ service.getUrl().toString());
		System.err.println("Is service Runing  ::"+service.isRunning());
		//service.sendOutputTo(New FileOutputStream("E:/Logfile/logFile.txt"));
		
		

	}
	@AfterTest()
	public void stopServer() {
		
		if (service.isRunning()==true) {
			
			service.stop();
			System.out.println("\n-----------------------------------"+"\nstopping the appium server....."
			+"\n"+df.format(new Date()));
		}

	}
	
	
}



