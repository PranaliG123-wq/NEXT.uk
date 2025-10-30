package com.nexa.uk;

import java.time.Duration;
import java.util.List;
//import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;  





public class ProjectObjectModel {
	public WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
    //Actions actions;

	public ProjectObjectModel(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		 this.actions = new Actions(driver);
	}

	public void openBrandFilter() {
		driver.findElement(By.cssSelector("button[data-testid=\"plp-filter-label-button-brand\"]")).click();

	}

	public void searchBrandName(String brandName) {
		WebElement searchBox = driver
				.findElement(By.cssSelector("div[data-testid=\"plp-hf-category-search-bar-input\"] input"));

		searchBox.clear();
		searchBox.sendKeys(brandName);
	}

	public void selectYumiBrand() {

		WebElement yumi = driver
				.findElement(By.cssSelector("label[data-testid=\"plp-facet-checkbox-brand-brand:yumi\"]"));
		if (!yumi.isSelected()) {
			yumi.click();

		}
		// driver.findElement(By.cssSelector("div[class=\"plp-r1n5wt\"]"));

	}

	public boolean isYumiApplied() {
		List<WebElement> products = driver.findElements(By.cssSelector(
				"p[title=\"Yumi Blue Cord Shirt Dress With All Over Squirrel Embroidery (AA8593) | £65\"]"));

		return products.size() > 0 && products.stream().allMatch(e -> e.getText().contains("albaray"));
	}

	// Size filter
	public void openSizeFilter() {
		driver.findElement(By.cssSelector("button[data-testid=\"plp-filter-label-button-size\"]")).click();

	}

	public void selectSize10() {
		WebElement size10 = driver
				.findElement(By.cssSelector("label[data-testid=\"plp-facet-checkbox-size-size:10\"]"));
		if (!size10.isSelected()) {
			size10.click();
		}
	}

	public boolean isSize10Applied() {
		List<WebElement> products = driver.findElements(By.cssSelector("input[tabindex=\"-1\"]")); // you can enhance
																									// this to check
																									// size
		return products.size() > 0;
	}

//    public void closeSizeFilter() {
//    	driver.findElement(By.cssSelector("button[data-testid=\"plp-filter-label-button-size\"]")).click();
//
//	}
	// Sort Filter
//	public void openSortFilter() {
//		driver.findElement(By.cssSelector("li[data-value=\"price\"]")).click();
//		
//}
//	public void selectSortOption(String optionText) {
//		WebElement sort = driver.findElement(By.cssSelector("div[data-testid=\"sentinelEnd\"]"));
//		if (!sort.isSelected()) {
//		sort.click();
//		}
//		
//		
//		    // Open the dropdown first
//		    openSortFilter();
//
//		    // Get all dropdown options
//		    List<WebElement> options = driver.findElements(By.cssSelector("ul[role='menu'] li"));
//
//		    for (WebElement option : options) {
//		        String text = option.getText().trim();
//		        if (text.equalsIgnoreCase(optionText)) {
//		            option.click();
//		            break;
//		        }
//		    }
//		}
//		
//		
//	}
//	
//	
//	

// Sort Filter
	public void selectSortLowToHigh() {
		// Click on sort dropdown
		WebElement sortButton = driver.findElement(By.cssSelector("div[id=\"desktop-sort-select\"]"));
		sortButton.click();

	}

	public boolean selectLowToHighOption() throws InterruptedException {

//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		    WebElement lowToHighOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-value='price']")));   // This is the "Low to High" option));
//
//		    // Click the "Low to High" option
//		    lowToHighOption.click();
//		    
//		    Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement sortButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-testid='plp-desktop-sort-button']")));
		sortButton.click();

		WebElement lowToHigh = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-value='price']")));
		lowToHigh.click();

		// WebElement activeSort =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id=\"desktop-sort-select\"]")));

		return lowToHigh.getText().equalsIgnoreCase("Price - Low to High");

	}
//------Login Valid------------
//	public void clickOnLogo() {
//		WebElement signInLogo = driver.findElement(By.cssSelector("div[data-testid=\"header-adaptive-my-account-icon-container\"]"));
//		signInLogo.click();
//		System.out.println("Clicked on sign in Logo");
//	}
	
	public void clickOnSignInButton() {
		WebElement signInButton = driver.findElement(By.cssSelector("div[class=\"c40d51cf3\"]")); //class="c40d51cf3"
		signInButton.click();
		System.out.println("Clicked on sign In Button button");
	}

	public void clickOnEmailField() {
		// Email input field
		WebElement emailField = driver.findElement(By.cssSelector("input[id='username']"));
		emailField.sendKeys("sayalihtpatil95@gmail.com");
		System.out.println("Entered in Email Feild");
	}

	public void clickOnPasswordField() {
		// Password input field
		WebElement passwordField = driver.findElement(By.cssSelector("input[class=\"input c060a2389 c838dd66d\"]"));
		passwordField.sendKeys("SayaliMatle1");
		System.out.println("Password Entered successfully");
	}

	public void showPasswordButton() {
		// password show button
		driver.findElement(By.cssSelector("a[id=\"showPasswordButton\"]")).click();
		System.out.println("clicked successfully on show password button");
	}


//---------- Login Invalid ----------
//public void clickOnInvalidEmailField() {
// // Invalid email input
// WebElement emailField = driver.findElement(By.cssSelector("input[id='username']"));
// emailField.clear();
// emailField.sendKeys("invaliduser@gmail.com");
// System.out.println("Entered Invalid Email");
//}
//
//public void clickOnInvalidPasswordField() {
// // Invalid password input
// WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
// passwordField.clear();
// passwordField.sendKeys("wrongpassword123");
// System.out.println("Entered Invalid Password");
//}
}