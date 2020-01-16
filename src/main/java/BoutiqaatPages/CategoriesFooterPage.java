package BoutiqaatPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Boutiqaat.Uttils.test.TestUtills;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CategoriesFooterPage {
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text ='Categories']")
	private WebElement Categoriestitle;
	
	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/list_catrgory")
	private List<WebElement> getAllCatlist;
	
	public CategoriesFooterPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	public void VerifyCategoryText() {
		String CategoryTitle = Categoriestitle.getText();
		System.out.println("===========Categories Title====================-"+ CategoryTitle);
		
	}
	
	public void getAllCategories() {
		//TestUtills testutill;
		//String allbrands = ((WebElement) getAllBrandlist).getText();
		//TestUtills.scrollScreentoview(0);
		for (WebElement allcats1 : getAllCatlist) {
			System.out.println("=================Size of List is===="+allcats1.getSize());
			System.out.println(allcats1.getText());
			
			
			
		}}
	
	
	//com.lezasolutions.boutiqaat:id/categoryimg

}
