package ps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

		public static void main(String[] args) throws InterruptedException {
			WebDriver driver=new ChromeDriver();
    driver.get("https://www.amazon.com");
    WebElement signInButton = driver.findElement(By.id("nav-link-accountList"));
    signInButton.click();
    WebElement emailInput = driver.findElement(By.id("ap_email"));
    emailInput.sendKeys("sprajnasmita@gmail.com");

    WebElement continueButton = driver.findElement(By.id("continue"));
    continueButton.click();
    WebElement passwordInput = driver.findElement(By.id("ap_password"));
    passwordInput.sendKeys("Smita@123");
//Breaking the flow of execution as The captcha authentication required 
    WebElement signInSubmitButton = driver.findElement(By.id("signInSubmit"));
    signInSubmitButton.click();
    Thread.sleep(5000);
    WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
    searchInput.sendKeys("laptop");
    searchInput.submit();
    WebElement firstProductLink = driver.findElement(By.xpath("//div[@data-component-type='s-search-result']//a[@class='a-link-normal a-text-normal']"));
    firstProductLink.click();
    WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
    addToCartButton.click();
    Thread.sleep(5000);
    WebElement cartButton = driver.findElement(By.id("nav-cart"));
    cartButton.click();
    WebElement proceedToCheckoutButton = driver.findElement(By.name("proceedToCheckout"));
    proceedToCheckoutButton.click();
    Thread.sleep(5000);
    WebElement deliveryOptionButton = driver.findElement(By.xpath("//a[@id='a-autoid-0-announce']"));
    deliveryOptionButton.click();
    Thread.sleep(5000);
    WebElement creditCardOption = driver.findElement(By.xpath("//span[contains(text(),'Credit / Debit / ATM Card')]"));
    creditCardOption.click();
    WebElement cardNumber = driver.findElement(By.xpath("//input[@name='addCreditCardNumber']"));
    cardNumber.sendKeys("98765432159753");

    WebElement expiryMonth = driver.findElement(By.xpath("//select[@name='ppw-expirationDate_month']"));
    expiryMonth.sendKeys("12");

    WebElement expiryYear = driver.findElement(By.xpath("//select[@name='ppw-expirationDate_year']"));
    expiryYear.sendKeys("2025");

    WebElement cvv = driver.findElement(By.xpath("//input[@name='ppw-accountHolderName']"));
    cvv.sendKeys("123");
   
    WebElement placeYourOrderButton = driver.findElement(By.xpath("//span[contains(text(),'Place your order')]"));
    placeYourOrderButton.click();

    Thread.sleep(5000);

    String pageTitle = driver.getTitle();
    assert pageTitle.contains("Order Confirmation");

    driver.quit();
}
}

