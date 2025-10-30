package com.womens;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.nexa.uk.Base;

public class TC_WomensFilters extends Base{
	
	// TC001: Navigate to Women > Dresses
    @Test(priority = 1)
    public void navigateToWomensDresses() throws InterruptedException { 
    	
    		WebElement searchBar = driver.findElement(By.cssSelector("input[data-testid='header-search-bar-text-input']"));
    		searchBar.sendKeys("All dresses", Keys.ENTER);
    		Thread.sleep(2000);

		//WebElement womenLink = driver.findElement(By.cssSelector("a[id=\"meganav-link-1\"]"));
        //womenLink.click();

        //WebElement dressesLink =driver.findElement(By.cssSelector("a[title=\"All Dresses\"] span"));
        //dressesLink.click();
        
        
     // Step 1: Click on the Brand filter dropdown
        WebElement brandFilterToggle = driver.findElement(By.cssSelector("button[data-testid=\"plp-filter-label-button-brand\"]"));
        brandFilterToggle.click();
        
      
        
        WebElement dropdownSearchBar = driver.findElement(By.cssSelector("input[class=\"MuiInputBase-input plp-mnn31\"]"));
        dropdownSearchBar.sendKeys("lipsy");
		Thread.sleep(2000);
		
		//input[class="PrivateSwitchBase-input plp-1m9pwf3"]
		
		//WebElement checkBox = driver.findElement(By.cssSelector("input[class=\"PrivateSwitchBase-input plp-1m9pwf3\"]")).click();
       
      WebElement checkBox= driver.findElement(By.cssSelector("input[class=\"PrivateSwitchBase-input plp-1m9pwf3\"]"));
      checkBox.click();
      Thread.sleep(2000);
        
    }
}