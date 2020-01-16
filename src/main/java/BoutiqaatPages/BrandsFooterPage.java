package BoutiqaatPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Primary;

import Boutiqaat.Uttils.test.TestUtills;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BrandsFooterPage {
	AppiumDriver<MobileElement> driver;
	TestUtills testutill;
	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/textview_toolbar_title")
	private WebElement titleText;
	
	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/branditem_text")
	////android.support.v7.widget.RecyclerView[@id='com.lezasolutions.boutiqaat:id/rv_allbrandlst']
	private List<WebElement> getAllBrandlist;
	
	public BrandsFooterPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver=driver;
	}
	public void VerifyBrandsText() {
		String brandsTitle = titleText.getText();
		System.out.println("===========BrandsTitle====================-"+ brandsTitle);
		
	}
	public HomePage getAllBrands() {
		//TestUtills testutill;
	//	String allbrands = ((WebElement) getAllBrandlist).getText();
		//TestUtills.scrollScreentoview(1);
		//testutil
		for (WebElement allbrands1 : getAllBrandlist) {
			System.out.println("=================Size of List is===="+allbrands1.getSize());
			System.out.println(allbrands1.getText());
			
		
			
		}
		return null;
		//return new CheckoutCodWithBrands(driver);
		//System.out.println("=========All brands list==========" + allbrands);
		
	}
	

}
