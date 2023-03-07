package BasicCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDrivers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		/*driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.close();*/
		
		/*WebDriver driver1;
		driver1=new EdgeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.close();*/
		
		driver=new FirefoxDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.close();
	}

}
