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
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
public class PopularSessionStepDef {

	private WebDriver driver;
	
    @Given("^the user navigates to the online store$")
    public void the_user_navigates_to_the_online_store() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\libraries_and_tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
    }

    @When("^the user clicks on an item$")
    public void the_user_clicks_on_an_item() {
    	driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img")).click();
    }

    @When("^you add an item to cart$")
    public void you_add_an_item_to_cart() {
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button")).click();
    }

    @When("^you add a second item to cart$")
    public void you_add_a_second_item_to_cart() {
    	driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a")).click();
    	driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[7]/div/div[1]/div/a[1]/img")).click();
    	driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button")).click();    	
    }

    @Then("^the page for that item should open$")
    public void the_page_for_that_item_should_open() {
    	String actual = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1")).getText();
    	assertThat(actual, equalTo("Faded Short Sleeve T-shirts"));
    	
    }

    @Then("^the cart should now have that item$")
    public void the_cart_should_now_have_that_item() throws InterruptedException {
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
    	String actual = driver.findElement(By.xpath("//*[@id=\"product_1_1_0_0\"]/td[2]/p/a")).getText();
    	assertThat(actual, equalTo("Faded Short Sleeve T-shirts"));
    }

    @Then("^the cart should have both items$")
    public void the_cart_should_have_both_items() throws InterruptedException {
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
    	
    	String actual = driver.findElement(By.xpath("//*[@id=\"summary_products_quantity\"]")).getText();
    	assertThat(actual, equalTo("2 Products"));
    	driver.close();
    }

}