package com.nexa.uk;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

	public WebDriver driver; // Correct type

//	@BeforeMethod
//	public void setup() {
//		driver = new FirefoxDriver();
//
//		driver.manage().window().maximize();
//		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		// driver.get("https://www.next.co.uk/");
//		driver.get("https://www.next.co.uk/shop/gender-women-category-dresses");
//
//		// ✅ Handle cookie popup if it appears
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		try {
//			WebElement rejectCookies = wait
//					.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-reject-all-handler")));
//			rejectCookies.click();
//			System.out.println("✅ Cookie popup dismissed");
//		} catch (Exception e) {
//		System.out.println("ℹ️ Cookie popup not found or already dismissed");
//		}
//	}

	public
	WebDriverWait wait;

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.next.co.uk/");
		driver.findElement(By.cssSelector("button[id=\"onetrust-accept-btn-handler\"]")).click();

		Thread.sleep(2000);

		// ✅ Open the target page
		//driver.get("https://www.next.co.uk/shop/gender-women-category-dresses");
		
//	        // ✅ Dismiss 
//	        Cookie Popup if appears
		//dismissCookiePopup();
	}

	public void dismissCookiePopup() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		try {
			WebElement rejectCookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-reject-all-handler")));
			rejectCookies.click();
			System.out.println("✅ Cookie popup dismissed");
		} catch (Exception e) {
			System.out.println("ℹ️ Cookie popup not found or already dismissed");
		}
	}
	
	

	@AfterMethod
	public void tearDown() {
		// if (driver != null) {
		driver.quit();
	}
}
