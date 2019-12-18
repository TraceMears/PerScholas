package selenium_tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest {
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\libraries_and_tools\\chromedriver.exe");
				
		driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/SpringSBA_Question2_ClassifiedAds/");
	}
	
	@AfterClass
	public static void cleanUp() {
		driver.close();
	}
	
	@Test
	public void loginTest() {
		driver.get("http://localhost:8080/SpringSBA_Question2_ClassifiedAds/");
	    driver.manage().window().setSize(new Dimension(1060, 666));
	    driver.findElement(By.linkText("Register user")).click();
	    driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).sendKeys("trace");
	    driver.findElement(By.id("password")).sendKeys("mears");
	    driver.findElement(By.id("user")).click();
	    driver.findElement(By.cssSelector("input:nth-child(3)")).click();
	    driver.findElement(By.cssSelector("html")).click();
//	    assertThat(true, equals(true));
		
	}
	
}
