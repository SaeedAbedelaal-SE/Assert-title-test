import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assert_title {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		String userName = "standard_user";
		String passWord = "secret_sauce";
		int expectedItems =5;
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(passWord);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		List<WebElement> myButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < myButtons.size(); i++) {
			myButtons.get(i).click();
		}
		String actualOfItems = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
		int actualNumOfItems = Integer.parseInt(actualOfItems);
		Assert.assertEquals(actualNumOfItems, expectedItems);

	}

}
