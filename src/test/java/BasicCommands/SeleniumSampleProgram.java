package BasicCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumSampleProgram {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		String currenturl=driver.getCurrentUrl();
		System.out.println(currenturl);
		
		String pagetitle=driver.getTitle();
		System.out.println(pagetitle);
		
		//String getpagesource=driver.getPageSource();
		//System.out.println(getpagesource);
		
		WebElement messageField=driver.findElement(By.id("single-input-field"));
		WebElement showButton=driver.findElement(By.id("button-one"));
		WebElement elementMessage=driver.findElement(By.id("message-one"));
		WebElement valueAField=driver.findElement(By.id("value-a"));
		WebElement valueBField=driver.findElement(By.id("value-b"));
		WebElement getTotalButton=driver.findElement(By.id("button-two"));
		WebElement totalMessage=driver.findElement(By.id("message-two"));
		
		messageField.sendKeys("Selenium test");
		showButton.click();
		String element=elementMessage.getText();
		System.out.println(element);
		valueAField.sendKeys("100");
		valueBField.sendKeys("200");
		getTotalButton.click();
		String total=totalMessage.getText();
		System.out.println(total);
		
		driver.close();
		
	}
}
