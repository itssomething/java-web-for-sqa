package selenium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserIncomeMinus {
	@Test
	public void abc() {
		String exePath = "E:\\ki 2 nam 4\\chromedriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();

		// Open ToolsQA web site
		String appUrl = "https://warm-castle-79003.herokuapp.com/users/new";
		driver.get(appUrl);
		
		WebElement userNameF = driver.findElement(By.id("user_name"));
		userNameF.sendKeys("vdmanh");

		WebElement IDNumF = driver.findElement(By.id("user_id_number"));
		IDNumF.sendKeys("123zxc");

		WebElement incomeF = driver.findElement(By.id("user_income"));
		incomeF.sendKeys("-1");

		WebElement passwordF = driver.findElement(By.id("user_password"));
		passwordF.sendKeys("123456");

		WebElement emailF = driver.findElement(By.id("user_email"));
		emailF.sendKeys("manh@mail.com");

		WebElement btnSubmit = driver.findElement(By.className("btn-primary"));
		btnSubmit.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h2")));
		String success = messageElement.getText();
		String expected = "1 error prohibited this user from being saved:";
		assertEquals(expected, success);
		driver.close();
	}
}
