package automation.testing;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasicTest {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUP() {
		System.setProperty("webdriver.chrome.driver", 
						"C:\\Users\\Student\\Desktop\\libraries_and_tools\\chromedriver.exe" );
		driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/SeleniumBasics/HomeServlet");
		//driver.get("http:\\perscholas.org");
		
	}	
	
	@Test
	public void testHeader() {
		WebElement we = driver.findElement(By.cssSelector("h1"));
		String actual = we.getText();
		assertThat(actual, equalTo("This is a header"));
	}
	
	@Test
	public void testLink() {
		driver.findElement(By.cssSelector("a")).click();
		String actual = driver.getTitle();
		assertThat(actual, equalTo("Per Scholas"));
	}

}
