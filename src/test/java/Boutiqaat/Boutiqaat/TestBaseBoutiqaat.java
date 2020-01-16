package Boutiqaat.Boutiqaat;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Boutiqaat.Uttils.test.TestUtills;
import BoutiqaatPages.BoutiqaatHamburgerMenu;
import BoutiqaatPages.BrandsFooterPage;
import BoutiqaatPages.CategoriesFooterPage;
import BoutiqaatPages.CelebritiesFooterPage;
import BoutiqaatPages.CheckoutCodWithBrands;
import BoutiqaatPages.HomePage;
import BoutiqaatPages.MyBagFooterPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

@Listeners(Boutiqaat.Uttils.test.TestListner.class)
public class TestBaseBoutiqaat  {
	static DesiredCapabilities cap;
	private static AppiumDriver<MobileElement> driver;
	private static AndroidDriver<MobileElement> androiddriver;
	static String NodePath = "C:/Program Files/nodejs/node.exe";
	static String AppiumMainJS_Path ="C:\\Users\\pradeep\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
	static AppiumDriverLocalService service ;
	static SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	HomePage homePage;
	BrandsFooterPage brandsFooterPage;
	CategoriesFooterPage categoryFotterPage;
	CelebritiesFooterPage celebrityFooterPage;
	MyBagFooterPage myBagFooterPage;
	CheckoutCodWithBrands checkoutCodWithBrands;
	BoutiqaatHamburgerMenu boutiqaatHamburgerMenu;
	
	public static AppiumDriver<MobileElement> getDriver() {
		return driver;
	}
	public void setDriver(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public static AndroidDriver<MobileElement> getDrivertest() {
		return (AndroidDriver<MobileElement>) driver;
	}
	public void setDriver(AndroidDriver<MobileElement> driver) {
		this.driver = androiddriver;
	}


	TestUtills testUtills;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	@BeforeSuite()
	public void extentReportSetup()
	{
		// start reporters
        htmlReporter = new ExtentHtmlReporter("BoutiqaatAutomationTestReports.html");
        // create ExtentReports and attach reporter(s)
         extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
		
	}

	@BeforeTest
	public void AppiumSetUp() throws InterruptedException, MalformedURLException {

		//public void startServer() throws InterruptedException {

		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(NodePath)).withAppiumJS(new File(AppiumMainJS_Path))
				.withIPAddress("127.0.0.1")
				.usingPort(4727));
		//.withLogFile(new File("E:/Logfile/logFile.txt")));

		System.out.println("Starting the Appium Server.........."+"\n"+df.format(new Date())+"\n---------------------------------");
		service.start();
		Thread.sleep(10000);
		System.out.println("======Wait,setting up Appuim capabilty===============");

		cap = new DesiredCapabilities();
		//	cap.setCapability("app", file.getAbsolutePath());
		cap.setCapability("platformName", "Android");
		cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability("platformVersion", "6.0");
		cap.setCapability("deviceName", "25.38.52.91:5555");
		//cap.setCapability("deviceName", "emulator-5554");
		//cap.setCapability("avd","Pixel_3_API_23");
		//cap.setCapability("appPackage", "vitaminshoppe.consumerapp");
		//cap.setCapability("appActivity","vitaminshoppe.consumerapp.LoadingActivity");
		cap.setCapability("appPackage", "com.lezasolutions.boutiqaat");
		cap.setCapability("appActivity","com.lezasolutions.boutiqaat.ui.welcome.WelcomeActivity");
		cap.setCapability("autoAcceptAlerts", "true");
		//cap.setCapability("autoGrantPermissions","true");
		cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
		// driver = new AndroidDriver(new URL("127.0.0.1:4723/wd/hub"), cap);
		//driver = new AndroidDriver(new URL(url), cap);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// RemoteWebDriver driver = new RemoteWebDriver(new
		URL url = new URL("http://127.0.0.1:4727/wd/hub");
		driver = new AndroidDriver<>(url,cap);
	//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// mCurrentFocus=Window{1fb71ed u0 com.lenovo.ideafriend/com.lenovo.ideafriend.alias.PeopleActivity}
		//  mFocusedApp=AppWindowToken{6ee29e6 token=Token{41a5041 ActivityRecord{ea1754b u0 com.lenovo.ideafriend/.alias.PeopleActivity t588}}}
		//return driver;
		
	
	}
	@Test(priority =1)
	public void navigateBoutiqaatBanner() throws InterruptedException, IOException {
		try {
			// creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("Navigate Boutiqaat banner", "Navigateing to Boutiqaat banner screen");
	        // log(Status, details)
	        test.log(Status.INFO, "Navigateing to Boutiqaat banner screen");
	        // info(details)
	        test.info("This step shows usage of info(details)");
	        	        // log with snapshot
	        test.fail("Banner load get failed", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			
			System.out.println("waiting for content to get Load");
			 test.log(Status.INFO, "waiting for content to get Load");
			Thread.sleep(10000);
			//driver.findElement(By.xpath("com.lezasolutions.boutiqaat:id/_tv_category_first'"));
			driver.findElement(By.id("com.lezasolutions.boutiqaat:id/_tv_category_first")).click();
			test.log(Status.PASS, "Navigated to Boutiqaat banner screen");
			Thread.sleep(10000);
			//			WebDriverWait wait = new WebDriverWait(driver, 5);
			//			wait.until(ExpectedConditions.alertIsPresent());
			//			driver.switchTo().alert().accept();
			//MobileElement title = driver.id("com.lezasolutions.boutiqaat:id/_tv_category_first')");
			//MobileElement tiltle1 = driver.findElementByClassName("android.widget.TextView");
			//	System.out.println(title.getText()+ " Page Opened");

		}
		catch(NoSuchElementException e){
			System.out.println("No List Found");
			e.printStackTrace();


		}

	}
//@Test(priority =2)
	public void testHomepage() throws InterruptedException{
		homePage = new HomePage(driver);
		 
		Thread.sleep(10000);
		homePage.clickOnMenStore();
		Thread.sleep(10000);
		//homePage.verifyBoutiqaatLogo();
		//Thread.sleep(10000);
		homePage.clickOnWomenStore();
		//Thread.sleep(10000);
		//homePage.verifyBoutiqaatLogo();
		//Thread.sleep(10000);
		homePage.verifyHamburgerMenuOption();
		Thread.sleep(10000);
		homePage.closeHamburgermenuOption();
		Thread.sleep(10000);
		checkoutCodWithBrands =homePage.NavigateToBrnadsListing();
		Thread.sleep(10000);
		brandsFooterPage.VerifyBrandsText();
		Thread.sleep(10000);
		homePage=brandsFooterPage.getAllBrands();
		Thread.sleep(10000);
		celebrityFooterPage =homePage.NavigateToCelebritesListing();
		Thread.sleep(10000);
		celebrityFooterPage.verifyCelebrityText();
		Thread.sleep(10000);
		celebrityFooterPage.getAllCategories();
		Thread.sleep(10000);
		categoryFotterPage =homePage.NavigateToCategoriesListing();
		Thread.sleep(10000);
		categoryFotterPage.VerifyCategoryText();
		Thread.sleep(10000);
		categoryFotterPage.getAllCategories();
		Thread.sleep(10000);
		checkoutCodWithBrands=homePage.NavigateToAddTobag();
		Thread.sleep(10000);
		myBagFooterPage.verifyMyBagText();
		Thread.sleep(10000);
		myBagFooterPage.VerifyBagEmptyCase();
		Thread.sleep(10000);
		checkoutCodWithBrands=homePage.NavigateToAddTobag();
		Thread.sleep(10000);
		myBagFooterPage.VerifywishListBtn();
		Thread.sleep(10000);
		myBagFooterPage.closeLoginWindow();
		Thread.sleep(20000);

	}
	
	@Test(priority =3)
	public void guestCheckoutcod() throws InterruptedException {
		
		homePage = new HomePage(driver);
		  ExtentTest test = extent.createTest("Guest Checkout By COD", "Guest Checkout");
	        // log(Status, details)
	        test.log(Status.INFO, "Navigateing to Boutiqaat banner screen");
//		Thread.sleep(10000);
//		homePage.clickOnMenStore();
//		Thread.sleep(10000);
//		homePage.clickOnWomenStore();
//		Thread.sleep(10000);
//		homePage.verifyHamburgerMenuOption();
//		Thread.sleep(10000);
//		homePage.closeHamburgermenuOption();
//		Thread.sleep(10000);
	        test.log(Status.INFO, "NavigateToBrnadsListing");
		checkoutCodWithBrands =homePage.NavigateToBrnadsListing();
		Thread.sleep(10000);
		//brandsFooterPage.VerifyBrandsText();
		//Thread.sleep(10000);
		//checkoutCodWithBrands=	brandsFooterPage.getAllBrands();
		//Thread.sleep(10000);
		test.log(Status.INFO, "Clicking on brand");
		checkoutCodWithBrands.clickBrand();
		Thread.sleep(10000);
		test.log(Status.INFO, "getting item price");
		checkoutCodWithBrands.getItemPrice();
		Thread.sleep(10000);
		test.log(Status.INFO, "Clicking onBuy now button");
		checkoutCodWithBrands.clickOnbuyNow();
		Thread.sleep(10000);
		checkoutCodWithBrands.clickOnCheckoutPrompt();
		Thread.sleep(10000);
		checkoutCodWithBrands.clickOnCheckoutbtn();
		Thread.sleep(10000);
		checkoutCodWithBrands.clickOnguestCheckoutbtn();
		Thread.sleep(10000);
		checkoutCodWithBrands.enterEmail();
		Thread.sleep(10000);
		checkoutCodWithBrands.clickcontinubtn();
		Thread.sleep(10000);
		checkoutCodWithBrands.clickOnAddNewAddressbtn();
		Thread.sleep(10000);
		checkoutCodWithBrands.selectFieldvalue();
		Thread.sleep(10000);
		checkoutCodWithBrands.enteringFirstName();
		Thread.sleep(10000);
		checkoutCodWithBrands.selectArea();
		Thread.sleep(15000);
		checkoutCodWithBrands.selectBlock();
		Thread.sleep(10000);
		checkoutCodWithBrands.enterStreet();
		Thread.sleep(10000);
		checkoutCodWithBrands.enteravenue();
		Thread.sleep(10000);
		driver.hideKeyboard();
		checkoutCodWithBrands.enterHouseBuilding();
		Thread.sleep(10000);
		checkoutCodWithBrands.enterFloorNumber();
		Thread.sleep(10000);
		getDriver().hideKeyboard();
		checkoutCodWithBrands.enterFlatNumber();
		Thread.sleep(10000);
		 checkoutCodWithBrands.enterPhoneNumber();
		Thread.sleep(10000);
		//testUtills.scrollElement("SAVE ADDRESS");
		checkoutCodWithBrands.clickonSaveAddressbtn();
		Thread.sleep(10000);
		checkoutCodWithBrands.clickOnContinuePayment();
		Thread.sleep(10000);
		checkoutCodWithBrands.clickOnCashOndeleveryOption();
		Thread.sleep(10000);
		checkoutCodWithBrands.clickPayNowBtn();
		Thread.sleep(10000);
		checkoutCodWithBrands.VerifyOrderText();
		Thread.sleep(10000);
		checkoutCodWithBrands.getOrderd();
		Thread.sleep(10000);
		checkoutCodWithBrands.Verifyordermessage();
		
		
	}
	//@Test(priority =3)
	public void loginCheckoutcod() throws InterruptedException {
		
		homePage = new HomePage(driver);
		  ExtentTest test = extent.createTest("Guest Checkout By COD", "Guest Checkout");
	        // log(Status, details)
	        test.log(Status.INFO, "Navigateing to Boutiqaat banner screen");
//		Thread.sleep(10000);
//		homePage.clickOnMenStore();
//		Thread.sleep(10000);
//		homePage.clickOnWomenStore();
//		Thread.sleep(10000);
//		homePage.verifyHamburgerMenuOption();
//		Thread.sleep(10000);
//		homePage.closeHamburgermenuOption();
//		Thread.sleep(10000);
	        test.log(Status.INFO, "NavigateToBrnadsListing");
		checkoutCodWithBrands =homePage.NavigateToBrnadsListing();
		Thread.sleep(10000);
		//brandsFooterPage.VerifyBrandsText();
		//Thread.sleep(10000);
		//checkoutCodWithBrands=	brandsFooterPage.getAllBrands();
		//Thread.sleep(10000);
		test.log(Status.INFO, "Clicking on brand");
		checkoutCodWithBrands.clickBrand();
		Thread.sleep(10000);
		test.log(Status.INFO, "getting item price");
		checkoutCodWithBrands.getItemPrice();
		Thread.sleep(10000);
		test.log(Status.INFO, "Clicking onBuy now button");
		checkoutCodWithBrands.clickOnbuyNow();
		Thread.sleep(10000);
		checkoutCodWithBrands.clickOnCheckoutPrompt();
		Thread.sleep(10000);
		checkoutCodWithBrands.getCartDetails();
		Thread.sleep(10000);
		checkoutCodWithBrands.clickOnCheckoutbtn();
		Thread.sleep(10000);
		checkoutCodWithBrands.clickOnloginCheckoutbtn();
		Thread.sleep(10000);
		checkoutCodWithBrands.enterEmailAddress();
		Thread.sleep(10000);
		checkoutCodWithBrands.enterPassword();
		Thread.sleep(10000);
		checkoutCodWithBrands.clickLoginbtn();
		Thread.sleep(10000);
		checkoutCodWithBrands.clickOnContinuePayment();
		Thread.sleep(10000);
		checkoutCodWithBrands.clickOnCashOndeleveryOption();
		Thread.sleep(10000);
		checkoutCodWithBrands.clickPayNowBtn();
		Thread.sleep(10000);
		checkoutCodWithBrands.VerifyOrderText();
		Thread.sleep(10000);
		checkoutCodWithBrands.getOrderd();
		Thread.sleep(10000);
		checkoutCodWithBrands.Verifyordermessage();
		
		
	}
	
	//@Test(priority =3)
		public void verifyMenuOption() throws InterruptedException {
			
			homePage = new HomePage(driver);
			  ExtentTest test = extent.createTest("Menu Option", "Opton list");
		        // log(Status, details)
		        test.log(Status.INFO, "Navigateing to Boutiqaat banner screen");
//			Thread.sleep(10000);
//			homePage.clickOnMenStore();
//			Thread.sleep(10000);
//			homePage.clickOnWomenStore();
//			Thread.sleep(10000);
		        boutiqaatHamburgerMenu=	homePage.verifyHamburgerMenuOption();
		        boutiqaatHamburgerMenu.getMenuList();
		        boutiqaatHamburgerMenu.getCountryist();
		        boutiqaatHamburgerMenu.verifyLoginState();
			Thread.sleep(10000);
	}
	@AfterTest
	public void stopServer() {

		if (service.isRunning()==true) {

			service.stop();
			System.out.println("\n-----------------------------------"+"\nstopping the appium server....."
					+"\n"+df.format(new Date()));
		}

	}	
	@AfterSuite
	public void flashextentreport() {
		extent.flush();
	}

}



