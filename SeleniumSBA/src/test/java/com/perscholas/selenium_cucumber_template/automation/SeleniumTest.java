package com.perscholas.selenium_cucumber_template.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\libraries_and_tools\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@AfterClass
	public static void shutDown() {
		driver.close();
	}
	
	@Test
	public void findByCssBasic() throws InterruptedException {
		//get to staff page
		driver.get("https://perscholas.org/");
	    driver.manage().window().setSize(new Dimension(1060, 666));
	    driver.findElement(By.cssSelector(".dropdown > #mapToggle")).click();
	    Thread.sleep(500);
	    driver.findElement(By.cssSelector(".list-group-item:nth-child(6) > a")).click();
	    driver.findElement(By.cssSelector(".navbar-subnav-right > li:nth-child(1) > a")).click();
	    driver.findElement(By.cssSelector(".col-md-4:nth-child(3) h3")).click();
		
	    //create list of all the tags that have staff names in them
	    List<String> staff = new ArrayList<String>();
	    staff.add(driver.findElement(By.xpath("//*[@id=\"greater-boston-team\"]/div/div[1]/a/div/hgroup/h5")).getText());
	    staff.add(driver.findElement(By.xpath("//*[@id=\"greater-boston-team\"]/div/div[2]/a/div/hgroup/h5")).getText());
	    staff.add(driver.findElement(By.xpath("//*[@id=\"greater-boston-team\"]/div/div[3]/a/div/hgroup/h5")).getText());
	    staff.add(driver.findElement(By.xpath("//*[@id=\"greater-boston-team\"]/div/div[4]/a/div/hgroup/h5")).getText());
	    staff.add(driver.findElement(By.xpath("//*[@id=\"greater-boston-team\"]/div/div[5]/a/div/hgroup/h5")).getText());
				
	    assertTrue(staff.contains("Robin Nadeau"));
	    assertFalse(staff.contains("Jake McIntosh"));	
		
	}
}
