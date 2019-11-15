package com.ae;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.lang.Thread;
import org.openqa.selenium.JavascriptExecutor;

public class TestAEusingTestNGTest {

	WebDriver driver = new FirefoxDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String SearchKeyWord = "black dress"; // Change to your keyword you wanted to search
	Thread th = new Thread();

	// This method is to navigate ae.com URL
	@BeforeClass
	public void init() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.navigate().to("https://www.ae.com");
	}

	 // To search keyword in ae.com	
	  @Test public void SearchProduct() throws Exception {	  
	  driver.findElement(By.partialLinkText("Search")).click();
	  driver.findElement(By.name("search")).sendKeys(SearchKeyWord);
	  driver.findElement(By.cssSelector("li.search-suggestion:nth-child(1)")).click
	  (); System.out.println("Search Complete"); }
	  
	  @Test(dependsOnMethods = { "SearchProduct" }) public void AddProductToCard()
	  throws Exception { th.sleep(5000);
	  driver.findElement(By.cssSelector("div.product-tile:nth-child(3)")).click();
	  System.out.println("adding going on");
	  js.executeScript("window.scrollBy(0,300)");
	  th.sleep(5000);
	  driver.findElement(By.cssSelector("div.select-control")).click();
	  driver.findElement(By.cssSelector("a.select-option-item:nth-child(1)")).click
	  (); driver.findElement(By.name("addToBag")).click(); 
	  th.sleep(2000);
	  driver.navigate().refresh();	  
	  }
	 
	@Test(dependsOnMethods = { "AddProductToCard" })
	
	public void CheckoutCard() throws Exception {
		th.sleep(5000);
		System.out.println("Checkout is here");
		driver.findElement(By.cssSelector("span.utilities-item-title.qa-utilities-item-title")).click();
		th.sleep(5000);
		js.executeScript("window.scrollBy(0,500)");
		th.sleep(5000);
		//Wait.until(ExpectedConditions.presenceOfElement(By.class("article-feed-title")));
		driver.findElement(
				By.cssSelector("button.btn-primary:nth-child(1)"))
				.click();		
	}
	
	@Test(dependsOnMethods = { "CheckoutCard" })
	public void PlaceOrder() throws Exception {
		th.sleep(5000);
		System.out.println("placeorder is here");
		driver.findElement(By.cssSelector("input.form-control.form-input-firstname.ember-text-field.ember-view")).sendKeys("satnamsingh");
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.cssSelector("input.form-control.form-input-lastname.ember-text-field.ember-view")).sendKeys("singh");
		driver.findElement(By.cssSelector("input.form-control.form-input-street-address.ember-text-field.ember-view")).sendKeys("457 Wil Oak Drive");
		driver.findElement(By.cssSelector("input.form-control.form-input-street-address2.ember-text-field.ember-view")).sendKeys("");
		driver.findElement(By.cssSelector("input.form-control.form-input-city.ember-text-field.ember-view")).sendKeys("Ofallon");
		driver.findElement(By.name("states")).click();
		th.sleep(5000);		
		driver.findElement(By.cssSelector("option.ember-view:nth-child(1)")).click();
		System.out.println("order placed");		
		
	}

	@AfterClass
	public void quit() {
		driver.close();
	}
}
