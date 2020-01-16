package BoutiqaatPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Boutiqaat.Boutiqaat.TestBaseBoutiqaat;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BoutiqaatHamburgerMenu  {
	CheckoutCodWithBrands chek ;
	
	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/tv_item")
	private List<WebElement> Munulist;
	
	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/img_flag")
	private List<WebElement> countrylist;
//	 com.lezasolutions.boutiqaat:id/button_signup_siginin
//	  SIGN IN / SIGN UP
//	  com.lezasolutions.boutiqaat:id/textview_username
	
	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/button_signup_siginin")
	private boolean nonlogin;
	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/textview_username")
	private WebElement logedin;
	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/button_signup_siginin")
	private WebElement notlogin;
	
	
	
	public BoutiqaatHamburgerMenu(AppiumDriver<MobileElement>driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getMenuList() {
		for(WebElement mlist :Munulist ) {
			
			//System.out.println("Lst is containd==" + mlist.getSize());
			System.out.println("Lst is containd==" + mlist.getText());
			
		}
		return Munulist.get(0).getText();
		
	}
	
	public void getCountryist() {
		for(WebElement mlist :countrylist ) {
			
			//System.out.println("Lst is containd==" + mlist.getSize());
			System.out.println("Lst is containd==" + mlist.getText());
			
		}
		
	}
	
	public void verifyLoginState() throws InterruptedException {
		
		if(nonlogin= true) {
			System.out.println("user is non login");
          notlogin.click();
          Thread.sleep(5000);
          chek.enterEmailAddress();
          Thread.sleep(5000);
          chek.enterPassword();
          Thread.sleep(5000);
          chek.clickLoginbtn();
          Thread.sleep(5000);
			
		}
		else {
			System.out.println(logedin.getText());
		}
		
		
	}
	
	
	

}
