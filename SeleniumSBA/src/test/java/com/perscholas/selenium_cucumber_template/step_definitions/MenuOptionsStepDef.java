package com.perscholas.selenium_cucumber_template.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

@RunWith(Cucumber.class)
public class MenuOptionsStepDef {

	private WebDriver driver;
	
    @Given("^user navigates to the online store$")
    public void user_navigates_to_the_online_store() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\libraries_and_tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
    }

    @When("^you use navigation menu to reach evening dresses$")
    public void you_use_navigation_menu_to_reach_evening_dresses() {
        Actions action = new Actions(driver);
        
        WebElement hover = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
        action.moveToElement(hover).perform();
        
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[2]/a")).click();
    }

    @When("^you add printed dress to the cart$")
    public void you_add_printed_dress_to_the_cart() {
    	Actions action = new Actions(driver);
        
        WebElement hover = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
        action.moveToElement(hover).perform();
        
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]")).click();
    }

    @Then("^you will be on the evening dresses page$")
    public void you_will_be_on_the_evening_dresses_page() {
    	String actual = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]")).getText();
    	assertThat(actual, equalTo("EVENING DRESSES "));
    }

    @Then("^printed dress should be in cart$")
    public void printed_dress_should_be_in_cart() throws InterruptedException {
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
    	String actual = driver.findElement(By.xpath("//*[@id=\"product_4_16_0_0\"]/td[2]/p/a")).getText();
    	assertThat(actual, equalTo("Printed Dress"));
    	driver.close();
    }

}
