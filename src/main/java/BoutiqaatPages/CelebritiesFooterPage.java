package BoutiqaatPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Boutiqaat.Uttils.test.TestUtills;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CelebritiesFooterPage {

	@AndroidFindBy(xpath="//android.widget.TextView[@text ='Celebrities']")
			private WebElement celebrityTitle;
	
	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/celebrity_name")
	private List<WebElement> getAllcelb ;
	
	public CelebritiesFooterPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	public void verifyCelebrityText() {
		String CelebTitle = celebrityTitle.getText();
		System.out.println("=====Celebrity Title====" + CelebTitle);
		
	}
	
	public void getAllCategories() {
		//TestUtills testutill;
		//String allbrands = ((WebElement) getAllBrandlist).getText();
		//TestUtills.scrollScreentoview(0);
		for (WebElement allcelb1 : getAllcelb) {
			System.out.println("=================Size of List is===="+allcelb1.getSize());
			System.out.println(allcelb1.getText());
			
			
			
		}}
	
}
