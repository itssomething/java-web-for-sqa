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

public class FailedCreateLoanMoneyTooGreat {
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
		amount.sendKeys("300000001");

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
		WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("alert-danger")));
		String success = messageElement.getText();
		String expected = "Loan created fail";
		
//		WebElement errorDetail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"error_explanation\"]/ul/li")));
//		String expectedErrorDetail = "Amount of money is greater than allowed";
//		String errorDetailText = errorDetail.getText();
		
//		assertEquals(errorDetail, errorDetailText);
		assertEquals(success, expected);
		driver.close();
	}
}
