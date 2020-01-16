package BoutiqaatPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	AppiumDriver<MobileElement> driver;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Women' and @index ='0']")
	private WebElement womenStore;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Men' and @index='0']")
	private WebElement menStore;
	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/imageview_toolbar_title")
	private WebElement boutiqaatLogo;
	@AndroidFindBy(xpath="//android.widget.ImageButton[@index='0']")
	private WebElement hamurgerMenuOption;
	@AndroidFindBy(xpath="//android.widget.ImageView")
	private WebElement wishlistOption;
	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/search")
	private WebElement searchOption;
	//com.lezasolutions.boutiqaat:id/close_navigation
	@AndroidFindBy(id="com.lezasolutions.boutiqaat:id/close_navigation")
	private WebElement closehamurgerMenuOption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text ='Brands']")
	private WebElement NavigateTobrands;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text ='Celebrities']")
	private WebElement NavigationToCelebrities;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text ='Categories']")
	private WebElement NavigationToCategories;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text ='My Bag']")
	private WebElement NavigationToCart;
	
	
	public HomePage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
	
	public void clickOnMenStore() {
		menStore.click();

	}
	public void clickOnWomenStore() {
		System.out.println("====Clicking on WomenStore====");
		womenStore.click();
	}
	public void verifyBoutiqaatLogo() {
		System.out.println("====Verify Boutiqaat Logo====");
		String title =	boutiqaatLogo.getText();
		String title1 =	boutiqaatLogo.getAttribute(title);
		System.out.println("title is=="+title1);
	}
	public BoutiqaatHamburgerMenu verifyHamburgerMenuOption() {
		System.out.println("====Verify Hamburgermenu====");
		hamurgerMenuOption.click();
		return new BoutiqaatHamburgerMenu(driver);

	}
	public void closeHamburgermenuOption() {
		System.out.println("====Navigating to close HamburgerMenu====");
		closehamurgerMenuOption.click();

	}
	public HomePage verifyWishlistOption() {
		System.out.println("====Navigating to wishlist====");
		wishlistOption.click();
		//System.out.println("Wishlist title is==" + wishlist);
		return null;
	
	}
	public CheckoutCodWithBrands NavigateToBrnadsListing() {
		System.out.println("====Navigating to  BrandsListing page====");
		NavigateTobrands.click();
		return new CheckoutCodWithBrands(driver);

	}
	public CelebritiesFooterPage NavigateToCelebritesListing() {
		System.out.println("====Navigating to CelebritesListing page====");
		NavigationToCelebrities.click();
		return new CelebritiesFooterPage(driver);

	}
	public CategoriesFooterPage NavigateToCategoriesListing() {
		System.out.println("====Navigating to CategoriesListing====");
		NavigationToCategories.click();
		return  new CategoriesFooterPage(driver);

	}
	public CheckoutCodWithBrands NavigateToAddTobag() {
		System.out.println("====Navigating to AddTobag====");
		NavigationToCart.click();
		return new CheckoutCodWithBrands(driver);

	}
	
}
