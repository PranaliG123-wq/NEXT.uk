

package com.womens;

import java.time.Duration;



//import org.assertj.core.api.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.nexa.uk.*;
import com.nexa.uk.Base;
import com.nexa.uk.ProjectObjectModel;




	public class LoginTest extends Base {
		
		
		
		//@Test
		public void loginWithValidCredentials() throws Exception {

		    // Step 1: Open login page
		    driver.get("https://auth.next.co.uk/u/login");

		    ProjectObjectModel loginPage = new ProjectObjectModel(driver);
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		    // Step 2: Enter email
		    loginPage.clickOnEmailField();   // Should handle sendKeys internally
		    Utilities.hardWait(1);

		    // Step 3: Enter password
		    loginPage.clickOnPasswordField();   // Should handle sendKeys internally
		    Utilities.hardWait(1);

		    // Step 4: (Optional) Show password
		    loginPage.showPasswordButton();
		    Utilities.hardWait(1);

		    // Step 5: Wait until Sign In button is clickable
		    By signInBtnLocator  = By.cssSelector("button[type='submit'][data-action-button-primary='true']");
		    WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(signInBtnLocator));

		    // Step 6: Scroll to Sign In button
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signInBtn);
		    Utilities.hardWait(1);

		    // Step 7: Click Sign In (try normal first, then JS if needed)
		    try {
		        signInBtn.click();
		    } catch (Exception e) {
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signInBtn);
		        System.out.println("⚠️ Normal click failed, used JS click instead.");
		    }

		    // Step 8: Wait for either redirect OR presence of My Account link
		    wait.until(ExpectedConditions.or(
		            ExpectedConditions.urlContains("next.co.uk"),
		            ExpectedConditions.presenceOfElementLocated(
		                    By.cssSelector("a[data-testid='header-myaccount-link']")) // ✅ fixed missing quote
		    ));

		    // Step 9: Assert login success
		    String currentUrl = driver.getCurrentUrl();
		    Assert.assertTrue(currentUrl.contains("next.co.uk"), "❌ Login failed or URL not redirected.");
		    System.out.println("✅ Login successful! Current URL: " + currentUrl);
		}
		
		

		@Test
	    public void verifyInvalidLoginErrorMessage() throws InterruptedException {
			
			//ProjectObjectModel errormsg = new ProjectObjectModel(driver);
		
			//errormsg.clickOnLogo();
			
			driver.get("https://auth.next.co.uk/u/login");
			
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
	        // Enter email
	        WebElement emailFieldLogo = driver.findElement(By.cssSelector("input[id='username']"));
	        emailFieldLogo.clear();
	        emailFieldLogo.sendKeys("invaliduser@gmail.com");

	        // Enter invalid password
	        WebElement passwordFieldLogo = driver.findElement(By.cssSelector("input[class=\"input c060a2389 c838dd66d\"]"));
	        passwordFieldLogo.clear();
	        passwordFieldLogo.sendKeys("wrongpassword123");
	       

	        // Click Sign In button
	       // WebElement signInButtonLogo = driver.findElement(By.cssSelector("div[class=\"c40d51cf3\"]"));
	        //signInButtonLogo .click();
	        
	        WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit'][data-action-button-primary='true']")));
	        signInBtn.click();

	        // Wait briefly for error message to appear
	        Thread.sleep(2000);

	        // Capture the error message
	        WebElement errorMsg = driver.findElement(By.cssSelector("span[class=\"msgboxTitle\"]"));
	        String actualErrorText = errorMsg.getText();

	        // Expected error message
	        String expectedErrorText = "Sorry, we have been unable to sign you in";

	        // Assertion
	        Assert.assertTrue(actualErrorText.contains(expectedErrorText),
	                "Error message not displayed correctly! Expected: " + expectedErrorText + " but got: " + actualErrorText);

	        System.out.println("✅ Error message displayed successfully: " + actualErrorText);
			
			
		}
	}