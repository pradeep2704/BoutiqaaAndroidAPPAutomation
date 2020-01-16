package BoutiqaatPages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Boutiqaat.Boutiqaat.TestBaseBoutiqaat;
import Boutiqaat.Uttils.test.TestUtills;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutCodWithBrands{
	AppiumDriver<MobileElement> driver;
	//AppiumDriver<WebElement> driver;
	TestUtills testutil;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='AA']")
	private WebElement brandId;

	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/item_price")
	private WebElement itemPrice;

	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/btn__buynow")
	private WebElement buyNowBtn;

	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/checkoutyes")
	private WebElement CheckoutPrompt;

	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/btn_checkout")
	private WebElement checkoutBtn;

	@AndroidFindBy(className="android.widget.RadioButton")
	private List<WebElement> guestCheckout;

	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/editText_guest_email")
	private WebElement emailId;

	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/button_continue")
	private WebElement continueBtn;

	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/label_add_new_address")
	private WebElement addNewAddress;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Please enter address (en-kw)']")
	private List<WebElement> selectfiled;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter Full Name']")
	private WebElement enterFirstName;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Area']")
	private List<WebElement> area;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Block']")
	private WebElement block;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Street Address']")
	private WebElement streetAddress;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Avenue']")
	private WebElement avenue;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter House/Building No.']")
	private WebElement houseBuildingName;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter Floor No.']")
	private WebElement enterFloorNo;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter Flat No.']")
	private WebElement enterFlatNo;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Phone Number']")
	private WebElement phoneNumber;

	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/save_address_btn")
	private MobileElement saveadddressbtn;

	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/continue_payment_btn")
	private WebElement continuePayment;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Cash On Delivery']")
	private WebElement cashOndelevery;

	@AndroidFindBy(xpath="//android.widget.Button[@text='PAY NOW']")
	private WebElement payNowBtn;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Order Successful']")
	private WebElement orderSuccessfully;

	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/tvOrderId")
	private WebElement orderId;

	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/tvSuccessMsg")
	private WebElement ordermessage;

	@AndroidFindBy(xpath="//com.lezasolutions.boutiqaat:id/btnViewOrder[@text='VIEW ORDER']")
	private WebElement viewOrderbtn;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Email ID']")
	private WebElement enteremail;

	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/editText_password")
	private WebElement enterPassword;

	@AndroidFindBy(xpath="//android.widget.Button[@text='LOGIN']")
	private WebElement clickLoginbtn;
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
	//com.lezasolutions.boutiqaat:id/edt_add_new_address_input_field[@text='Street Address']


	public CheckoutCodWithBrands(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver=driver;

	}

	public void clickBrand() {
		System.out.println("================Clicking on Brand=====");
		//testutil.scrollElement("ACM");
		brandId.click();

	}

	public void getItemPrice() {
		System.out.println("The Product price is ===" + itemPrice.getText());

	}
	public void clickOnbuyNow() {
		System.out.println("======Clicking on BuyNow from plp====");
		buyNowBtn.click();

	}

	public void clickOnCheckoutPrompt() {
		System.out.println("======Clicking on Checkout Prompt from plp====");
		CheckoutPrompt.click();

	}

	public void clickOnCheckoutbtn() {
		System.out.println("======Clicking on Checkoutbtn  ====");
		checkoutBtn.click();

	}

	public void clickOnguestCheckoutbtn() {
		boolean bvalue = false;

		System.out.println("======Clicking on GuestCheckoutbtn====");
		System.out.println("   "+guestCheckout);
		bvalue =	guestCheckout.get(0).isSelected();
		System.out.println(bvalue);
		if(bvalue = true) {
			guestCheckout.get(1).click();
		}else {
			guestCheckout.get(0).click();
		}
	}
	public void clickOnloginCheckoutbtn() {
		boolean bvalue = false;

		System.out.println("======Clicking on GuestCheckoutbtn====");
		System.out.println("   "+guestCheckout);
		bvalue =	guestCheckout.get(1).isSelected();
		System.out.println(bvalue);
		if(bvalue = true) {
			guestCheckout.get(0).click();
		}else {
			guestCheckout.get(1).click();
		}
	}

	public void enterEmail() {
		System.out.println("======Entering Email id====");
		emailId.sendKeys("test121@yopmail.com");


	}
	//continueBtn
	public void clickcontinubtn() {
		System.out.println("======CLicking on continue btn====");
		continueBtn.click();


	}
	//	@AndroidFindBy(xpath="//android.widget.EditText[@text='Email ID']")
	//	private WebElement enteremail;
	public void enterEmailAddress() {
		System.out.println("======Entering email id ====");
		enteremail.sendKeys("testid@yopmail.com");

	}
	//	
	//	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/editText_password")
	//	private WebElement enterPassword;
	public void enterPassword() {
		System.out.println("======EnteringPassword ====");
		enterPassword.sendKeys("password@123");

	}
	//	@AndroidFindBy(xpath="//android.widget.Button[@text='LOGIN']")
	//	private WebElement clickLoginbtn;
	public void clickLoginbtn() {
		System.out.println("======Login btn====");
		clickLoginbtn.click();

	}

	public void clickOnAddNewAddressbtn() {
		System.out.println("======Clicking on Add New Address ====");
		addNewAddress.click();

	}

	public void selectFieldvalue() {
		System.out.println("======Selecting Field Value====");
		//testutil.selectValue(selectfiled);
		for(WebElement ele:selectfiled) {
			System.out.println("==input value==" +ele);
			System.out.println(ele.getText());
			ele.click();

		}
	}

	public void enteringFirstName() {
		System.out.println("======Entering FirstName====");
		enterFirstName.sendKeys("TestTeam");

	}

	public void selectArea() {
		System.out.println("======selecting  Area ====");
		//testutil.selectValue(area);
		for(WebElement ele:area) {
			System.out.println("==input Area==" + ele);
			//System.out.println(ele.getText());
			ele.click();
		}
	}

	public void selectBlock() {
		System.out.println("======Selecting block====");
		block.click();
		block.sendKeys("2");
//		for(WebElement ele:block) {
//			System.out.println("==input block==" + ele);
//		System.out.println(ele.getText());
//			ele.click();
//			ele.sendKeys("2");
//		}
		//block.click();
		


	}

	public void enterStreet() {
		System.out.println("======Entering Street value ====");
		streetAddress.sendKeys("TestStreet");

	}

	////com.lezasolutions.boutiqaat:id/edt_add_new_address_input_field[@text='Street Address']
	//streetfield
	public void enteravenue() throws InterruptedException  {
		System.out.println("======Entering avenue ====");
		avenue.sendKeys("test");


	}

	public void enterHouseBuilding() {
		System.out.println("======Entering House building====");
		houseBuildingName.sendKeys("test house");
		//driver.hideKeyboard();
	}

	public void enterFloorNumber() {
		System.out.println("======Entering Floor number====");
		enterFloorNo.sendKeys("789");



	}

	public void enterFlatNumber() {
		System.out.println("======Entering Flat number====");
		enterFlatNo.sendKeys("987");
		//driver.hideKeyboard();
	}

	public void enterPhoneNumber() {

		System.out.println("======Entering phone number====");
		phoneNumber.sendKeys("9876543210");
		//String noum ="SAVE ADDRESS";
		TestUtills.scrollElement("SAVE ADDRESS");
		//return null;
	}

	public void clickonSaveAddressbtn() {
		System.out.println("======Clicking on saveAddress btn====");
		saveadddressbtn.click();
	}

	public void clickOnContinuePayment() {
		System.out.println("======Clicking on continue Payment btn====");
		continuePayment.click();
	}

	public void clickOnCashOndeleveryOption() {
		System.out.println("======Clicking on cash on delivery Option====");
		cashOndelevery.click();
	}

	public void clickPayNowBtn() {
		System.out.println("======Clicking on PayNowBtn ====");
		payNowBtn.click();
	}

	public void VerifyOrderText() {
		System.out.println("======Clicking on BuyNow from plp====");
		String ordertext = orderSuccessfully.getText();
		System.out.println("====Order Text is===" +ordertext );
	}

	public void getOrderd() {
		System.out.println("======getting OrderId====");
		String orderIdIs = orderId.getText();
		System.out.println("===OrderID is=====" +orderIdIs );
	}

	public void Verifyordermessage() {
		String expectedText ="Thank you for shopping at Boutiqaat. Your order will be delivered within 72 hours.";
		System.out.println("======verifieng ordermessage ====");
		String actualtext = ordermessage.getText();
		assertEquals(actualtext, expectedText);
		System.out.println("=====Actual Text===" + actualtext);


	}
	public void getCartDetails() {
		System.out.println("====Verifieng Cart details====");
		String getitemCount=itemCount.getText();	
		System.out.println("ItemCountIs ::"+ getitemCount);
		String getbagTotal=	bagTotal.getText();	
		System.out.println("BagTotal ::"+ getbagTotal);
		String getskutext=	skuText.getText();	
		System.out.println("SKUIs ::"+ getskutext);
		String getpricetext=	pricetext.getText();	
		System.out.println("PRICEIS ::"+ getpricetext);
		String getsubTotal=	subTotal.getText();	
		System.out.println("SKUIs ::"+ getsubTotal);



	}

	public void viewOrderbutton() {
		System.out.println("======Clicking on viewOrderbutton from from order confirmation page====");
		viewOrderbtn.click();
	}





}
