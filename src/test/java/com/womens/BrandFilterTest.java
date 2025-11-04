package com.womens;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nexa.uk.Base;
import com.nexa.uk.ProjectObjectModel;

public class BrandFilterTest extends Base {

     //@Test(priority = 2)

	public void verifyyumiBrandSelection() throws InterruptedException {
		driver.get("https://www.next.co.uk/shop/gender-women-category-dresses");
		ProjectObjectModel brandPage = new ProjectObjectModel(driver);

		brandPage.openBrandFilter();
		brandPage.searchBrandName("Yumi");

		brandPage.selectYumiBrand();

		Thread.sleep(4000);

		// Assert.assertTrue(brandPage.isYumiApplied(), "Yumi brand filter not applied
		// properly");
	}

	//@Test(priority = 1)
	public void verifySize10FilterSelection() throws InterruptedException {
		driver.get("https://www.next.co.uk/shop/gender-women-category-dresses");
		ProjectObjectModel filterPage = new ProjectObjectModel(driver);

		filterPage.openSizeFilter();
		filterPage.selectSize10();
		// filterPage.closeSizeFilter();

		Thread.sleep(3000); // 👈 later replace with WebDriverWait

		Assert.assertTrue(filterPage.isSize10Applied(), "Size 10 filter not applied properly");

		System.out.println("✅ Size 10 filter applied successfully");
	}

//	@Test(priority = 3)
//	public void verifySortByPriceLowToHigh() throws InterruptedException {
//		// Step 1: Navigate to Women's PLP page
//		driver.get("https://www.next.co.uk/shop/gender-women-0");
//
//		BrandFilterPage plpPage = new BrandFilterPage(driver);
//		
//
//		// Step 2: Select "Price: Low – High" from sort filter
//		plpPage.selectSortOption("Price: Low – High");
//
//		// Step 3: Wait for the page to reload after sorting
//		Thread.sleep(5000);
//
//		// Step 4: Get product prices
//		List<WebElement> priceElements = driver.findElements(By.cssSelector("span[data-testid='productPrice']"));
//
//		double previousPrice = 0.0;
//		for (WebElement priceElement : priceElements) {
//			String priceText = priceElement.getText().replace("£", "").trim();
//
//			if (!priceText.isEmpty()) {
//				double currentPrice = Double.parseDouble(priceText);
//
//				// Verify ascending order
//				Assert.assertTrue(currentPrice >= previousPrice,
//						"❌ Prices not sorted ascending. Current: " + currentPrice + " Previous: " + previousPrice);
//
//				previousPrice = currentPrice;
//			}
//		}
//
//		System.out.println("✅ Sort by 'Price: Low – High' filter verified successfully.");
//	}
//}
	
	@Test
	public void verifySortByPriceLowToHigh() throws InterruptedException {
	    driver.get("https://www.next.co.uk/shop/gender-women/category-dresses");
         ProjectObjectModel sortFilter = new ProjectObjectModel(driver);
         
        // sortFilter.selectSortLowToHigh();
         sortFilter.selectLowToHighOption();
         
        
         
         Assert.assertTrue(sortFilter.selectLowToHighOption(), "Sort not applied properly");

         
         System.out.println("Sort low to high filter is applied properly");
	    
	    
	}
}
