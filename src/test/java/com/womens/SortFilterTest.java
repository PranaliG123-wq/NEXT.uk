package com.womens;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.nexa.uk.Base;


public class SortFilterTest extends Base {

    @Test
    public void testSortLowToHigh() {
        // Click Sort dropdown
        WebElement sortDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div[data-testid='plp-desktop-sort-button']")));
        sortDropdown.click();

        // Click on "Price: Low - High"
        WebElement lowToHigh = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("li[data-value='price']")));
        lowToHigh.click();

        System.out.println("✅ Low to High sort filter applied");
    }

    @Test
    public void testSortHighToLow() {
        // Click Sort dropdown
        WebElement sortDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div[data-testid='plp-desktop-sort-button']")));
        sortDropdown.click();

        // Click on "Price: High - Low"
        WebElement highToLow = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("li[data-value='pricedesc']")));
        highToLow.click();

        System.out.println("✅ High to Low sort filter applied");
    }

    }

