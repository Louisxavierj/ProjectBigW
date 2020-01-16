package BigW;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import DataDriven.ExcelIntegration;

public class Automation extends ExcelIntegration{
	public static void main(String[] args) throws IOException, AWTException {
//Browser Launch
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\BigW\\ProjectBigW\\ProjectBigW\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigw.com.au/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//getTitle
		String title = driver.getTitle();
		System.out.println(title);
//currentUrl
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
//JavscriptExecutor		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement register = driver.findElement(By.xpath("//span[contains(text(),'Login/Register')]"));
		js.executeScript("arguments[0].click()", register);
//getText	
		WebElement text = driver.findElement(By.xpath("//p[contains(text(),'allows you to:')]"));
		String text2 = text.getText();
		System.out.println(text2);
		
		WebElement userEmail = driver.findElement(By.id("j_username"));
		userEmail.sendKeys(getData(2, 0));
//getAttribute
		String user = userEmail.getAttribute("value");
		System.out.println(user);
		WebElement PassWord = driver.findElement(By.id("j_password"));
		PassWord.sendKeys(getData(2, 1));
		String pass = PassWord.getAttribute("value");
		System.out.println(pass);
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
//Mouse Over
		Actions ac = new Actions(driver);
		WebElement book = driver.findElement(By.xpath("(//a[contains(text(),'Books')])[2]"));
		ac.moveToElement(book).perform();
		driver.findElement(By.xpath("(//a[text()='Childrens Books'])[1]")).click();
		WebElement sman = driver.findElement(By.xpath("(//a[@href='http://www.bigw.com.au/product/superman-paint-with-water/p/78451/'])[1]"));
		js.executeScript("arguments[0].click()", sman);
		driver.findElement(By.id("addToCartButtonNew")).click();
		WebElement pinCode = driver.findElement(By.id("productPageLocationInput"));
		pinCode.sendKeys(getData(4, 0));
//Robot Class
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("(//a[@href='/cart'])[1]")).click();
//ScrollDown
		js.executeScript("window.scrollTo(0,document.body.scrollHight)");
//TakesScreenshot
		TakesScreenshot tk = (TakesScreenshot)driver;
		File temp = tk.getScreenshotAs(OutputType.FILE);
		File desc = new File("C:\\Users\\admin\\BigW\\ProjectBigW\\ProjectBigW\\Screenshot\\BigW.png");
		FileUtils.copyFile(temp, desc);
	
	}

}
