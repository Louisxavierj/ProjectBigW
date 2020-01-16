package DataDriven;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBook extends ExcelIntegration{
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\admin\\BigW\\ProjectBigW\\ProjectBigW\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys(getData(1,0));
		WebElement passWord = driver.findElement(By.id("pass"));
		passWord.sendKeys(getData(2,0));
		System.out.println("***END***");
		
}}
