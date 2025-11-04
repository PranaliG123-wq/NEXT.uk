package com.womens;


	import com.nexa.uk.ProjectObjectModel;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	public class DataDrivenFilterTest {

	    @DataProvider(name = "FilterData")
	    public Object[][] getFilterData() {
	        return new Object[][] {
	                {"Black", "M", "Nike", 50, 300},
	                {"Red", "L", "Adidas", 100, 400},
	                {"Blue", "S", "Puma", 150, 350}
	        };
	    }

	    @Test(dataProvider = "FilterData")
	    public void applyFiltersUsingDataDriven(String colour, String size, String brand, int minPrice, int maxPrice) throws InterruptedException {
	        WebDriver driver = new ChromeDriver();
	        //driver.manage().window().maximize();
	       // driver.get("https://www.next.co.uk/search?w=all%20women%20dresses");

	        ProjectObjectModel pom = new ProjectObjectModel(driver);

	        // Step 1: Click "More" to show all hidden filters
	        pom.clickMoreFilters();

	        // Step 2: Apply filters using data from DataProvider
	        pom.applyColourFilter(colour);
	        pom.applySizeFilter(size);
	        pom.applyBrandFilter(brand);
	        pom.adjustPriceSlider(minPrice, maxPrice);

	        System.out.println("✅ Filters applied for: "
	                + colour + " | " + size + " | " + brand
	                + " | Price: " + minPrice + " - " + maxPrice);

	        Thread.sleep(2000);
	        driver.quit();
	    }
	}



