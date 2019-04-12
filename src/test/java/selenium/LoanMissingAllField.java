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

public class LoanMissingAllField {
	@Test
	public void abc() {
		String exePath = "E:\\ki 2 nam 4\\chromedriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();

		String appUrl = "https://warm-castle-79003.herokuapp.com/loans/new";
		driver.get(appUrl);

		WebElement btnSubmit = driver.findElement(By.className("btn-primary"));
		btnSubmit.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("alert-danger")));
		String success = messageElement.getText();
		String expected = "Loan created fail";
		assertEquals(success, expected);
		driver.close();
	}
}
