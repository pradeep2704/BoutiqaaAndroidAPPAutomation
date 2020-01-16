package Boutiqaat.Uttils.test;



import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.xml.sax.Locator;

import Boutiqaat.Boutiqaat.TestBaseBoutiqaat;
import android.renderscript.Element;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TestUtills extends TestBaseBoutiqaat {
	
	//AppiumDriver  driver;
	//private static AppiumDriver<MobileElement> driver;

//	public TestUtills(AppiumDriver<MobileElement>driver) {
//		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//		this.driver = driver;
		// TODO Auto-generated constructor stub
	
	//}
//	public static long PAGE_LOAD_TIMEOUT = 20;
//	public static long IMPLICIT_WAIT = 10;
//	
//	public static String TESTDATA_SHEET_PATH ="D:/Android workspace/FreeCrmTest/src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx";
//	static Workbook book;
//	static Sheet sheet;
	
	public void switchToFrame() {
		getDriver().switchTo().frame("mainpanel");
		
		
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException  {
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
		}
	
	public static void scrollScreen() {
		
		TouchActions action = new TouchActions(getDriver());
		action.scroll(0, 1000);
		action.perform();
		
	}
public static void scrollScreentoview(WebElement uiElement) {
	MobileElement listitem = getDriver().findElement(
	MobileBy.AndroidUIAutomator(
     "new UiScrollable(new UiSelector()).scrollIntoView(" + "new uiSelector().description(\"uiElement\"));"));
//          + "resourceId(\"" + scrollableList + "\")).getChildByText("
//                    + "new UiSelector().className(\"" + elementClassName + "\"), \"" + anytext + "\")"));
//		
	
}

public static void scrollToView(Element en) {
	  AndroidDriver<?> driver = (AndroidDriver<?>) getDriver();
	  WebElement elementScroll = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
	    + ".text(\"Maui Now \")).scrollIntoView(new UiSelector().text(\"Maui Now\"));");
	  //+ ".text(\"" + el +"\")).scrollIntoView(new UiSelector().text(\""+ el +"\"));");
	  elementScroll.getText();
	 }

public MobileElement scrollToExactElement(MobileElement ele,String str) {
	return ((AndroidElement) ele)
			.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())."
					+ "scrollIntoView(" + "new UiSelector().text(\""+ str +"\"));");
	 }

public static void scrollToElement(MobileElement ele,String str) {
	((AndroidElement) ele)
			.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())."
					+ "scrollIntoView(" + "new UiSelector().textContains(\""+ str +"\"));");
	 }

public static void scrollElement(String str) {
	((AndroidDriver<MobileElement>)TestBaseBoutiqaat.getDrivertest())
			.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0))"
					+ ".scrollIntoView(new UiSelector().text(\""+str+"\").instance(0))");
					
 }


public void swipeDirection(String direction , WebElement ele){
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
   // HashMap<String, String> scrollObject = new HashMap<String, String>();
   // scrollObject.put("direction", "up");
   // scrollObject.put("xpath", ele);
   // js.executeScript("mobile: scroll", scrollObject);
	js.executeScript(direction, ele);
}




public void selectValue(WebElement element) {
//	Select select = new  Select(element);
//	select.selectByIndex(2);
	 Select oSelect = new Select(getDriver().findElement((By) element));
	 List <WebElement> elementCount = oSelect.getOptions();
	 int iSize = elementCount.size();
	 for(int i =0; i<iSize ; i++){
	 String sValue = elementCount.get(i).getText();
	 System.out.println(sValue);
	 }
	
	
}


}



	
