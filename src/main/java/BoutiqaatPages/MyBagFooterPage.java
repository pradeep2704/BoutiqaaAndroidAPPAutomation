package BoutiqaatPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyBagFooterPage {

	@AndroidFindBy(xpath ="//android.widget.TextView[@text ='My Bag']")
	private WebElement myBagFooterPage;


	@AndroidFindBy(xpath ="//android.widget.TextView[@text ='Your bag is empty!']")
	private WebElement  verifyBagEmptyText;

	@AndroidFindBy(id ="com.lezasolutions.boutiqaat:id/btn_add_from_wishlist")
	private WebElement wishListBtn;

	@AndroidFindBy(id ="com.lezasolutions.boutiqaat:id/btn_continue_shopping")
	private WebElement continueShoopingBtn;
	
	@AndroidFindBy(id ="com.lezasolutions.boutiqaat:id/login_close")
	private WebElement closeWindow;
	
	@AndroidFindBy(id ="com.lezasolutions.boutiqaat:id/skuTxt")
	private WebElement skuText;
	
	@AndroidFindBy(id ="com.lezasolutions.boutiqaat:id/priceTxt")
	private WebElement pricetext;
	
	@AndroidFindBy(id ="com.lezasolutions.boutiqaat:id/payable")
	private WebElement subTotal;
	
	@AndroidFindBy(id ="com.lezasolutions.boutiqaat:id/item_count")
	private WebElement itemCount;
	
	@AndroidFindBy(id ="com.lezasolutions.boutiqaat:id/total_cost")
	private WebElement bagTotal;
	
//	SKU: com.lezasolutions.boutiqaat:id/skuTxt
//	Price:-	com.lezasolutions.boutiqaat:id/priceTxt
//	SUB Total	com.lezasolutions.boutiqaat:id/payable		
//	ITEM Count -com.lezasolutions.boutiqaat:id/item_count
//	Bag Total	com.lezasolutions.boutiqaat:id/total_cost
	
	//android.widget.TextView[@text ='Close']


	public MyBagFooterPage(AppiumDriver<MobileElement>driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void verifyMyBagText() {
		String myBag = myBagFooterPage.getText();
		System.out.println("==========My Bag Title===========" + myBag);
	}

	public void VerifyBagEmptyCase() {
		if(verifyBagEmptyText != null) {
			continueShoopingBtn.click();

		}
		else {
			String Emptytext = verifyBagEmptyText.getText();
			System.out.println("===========Your Bag is Empty====" + Emptytext);
		}
	}
	public void verifyBagNonEmptyCase() {

		if(verifyBagEmptyText != null) {
			continueShoopingBtn.click();

		}
		else {
			String Emptytext = verifyBagEmptyText.getText();
			System.out.println("===========Your Bag is Empty====" + Emptytext);
		}
	
		
	}

	public void VerifywishListBtn() {
		if(verifyBagEmptyText != null) {
			wishListBtn.click();

		}
		else {
			String Emptytext = verifyBagEmptyText.getText();
			System.out.println("===========Your Bag is Empty====" + Emptytext);
		}
	}
	
	public void closeLoginWindow() {
		System.out.println("====Closing Wishlist====");
		closeWindow.click();
		
	}
	
	public HomePage getCartDetails() {
	System.out.println("====Verifieng Cart details====");
	String getskutext=	skuText.getText();	
	System.out.println("SKUIs ::"+ getskutext);
	String getpricetext=	pricetext.getText();	
	System.out.println("PRICEIS ::"+ getpricetext);
	String getsubTotal=	subTotal.getText();	
	System.out.println("SKUIs ::"+ getsubTotal);
	String getitemCount=	itemCount.getText();	
	System.out.println("SKUIs ::"+ getitemCount);
	String getbagTotal=	bagTotal.getText();	
	System.out.println("SKUIs ::"+ getbagTotal);
	return null;
	}

}



