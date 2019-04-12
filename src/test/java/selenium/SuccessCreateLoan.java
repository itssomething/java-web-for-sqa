package selenium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

//import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

public class SuccessCreateLoan {
	@Test
	public void abc() {
		String exePath = "E:\\ki 2 nam 4\\chromedriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();

		// Open ToolsQA web site
		String appUrl = "https://warm-castle-79003.herokuapp.com/loans/new";
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
		

		
		WebElement rate = driver.findElement(By.id("loan_current_interest_rate"));
		rate.sendKeys("0.07");

		WebElement amount = driver.findElement(By.id("loan_amount_of_money"));
		amount.sendKeys("1000000");

		WebElement period = driver.findElement(By.id("loan_number_of_period"));
		period.sendKeys("12");		

		WebElement date = driver.findElement(By.xpath("//form//input[@name='loan[time_of_disbursement]']"));
		date.sendKeys("02022019");
		date.sendKeys(Keys.TAB);
		date.sendKeys("2019");
		
		Select drpUser = new Select(driver.findElement(By.id("loan_user_id")));
		drpUser.selectByVisibleText("123");
		
		Select drpLoanType = new Select(driver.findElement(By.id("loan_loan_type")));
		drpLoanType.selectByVisibleText("Spending");
		
		WebElement btnSubmit = driver.findElement(By.className("btn-primary"));
		btnSubmit.click();
//
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("flash")));
		String success = messageElement.getText();
		String expected = "Loan created success";
		assertEquals(success, expected);
		driver.close();
	}

}
