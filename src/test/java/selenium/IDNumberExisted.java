package selenium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

//import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

public class IDNumberExisted {
	@Test
	public void abc() {
		String exePath = "E:\\ki 2 nam 4\\chromedriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();

		// Open ToolsQA web site
		String appUrl = "https://warm-castle-79003.herokuapp.com/users/new";
		driver.get(appUrl);
//		WebElement btnSubmit = driver.findElement(By.className("btn-primary"));
//		btnSubmit.click();

//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement messageElement = wait.until(
//            ExpectedConditions.presenceOfElementLocated(By.tagName("h2")));
//		String failCreate = messageElement.getText();
//		String expected = "5 errors prohibited this user from being saved:";
//		System.out.println(failCreate == expected);
//		assertEquals(failCreate, expected);

		WebElement userNameF = driver.findElement(By.id("user_name"));
		userNameF.sendKeys("other name");

		WebElement IDNumF = driver.findElement(By.id("user_name"));
		IDNumF.sendKeys("123zxc");

		WebElement incomeF = driver.findElement(By.id("user_income"));
		incomeF.sendKeys("1000000");

		WebElement passwordF = driver.findElement(By.id("user_password"));
		passwordF.sendKeys("123456");

		WebElement emailF = driver.findElement(By.id("user_email"));
		emailF.sendKeys("manh@mail.com");

		WebElement btnSubmit = driver.findElement(By.className("btn-primary"));
		btnSubmit.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("flash")));
		String success = messageElement.getText();
		String expected = "1 errors prohibited this user from being saved:";
		driver.close();
	}

}
