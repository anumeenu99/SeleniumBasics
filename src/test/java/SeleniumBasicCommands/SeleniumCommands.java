package SeleniumBasicCommands;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumCommands {
	public WebDriver driver;

	public void testInitialise(String browser) {
		
		if (browser.equals("chrome")) 
		{
			driver = new ChromeDriver();
		} 
		else if (browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		} 
		else if (browser.equals("edge"))
		{
			driver = new EdgeDriver();
		} 
		else 
		{
			try {
				throw new Exception("Invalid browser");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@BeforeMethod
	public void setUp() {
		testInitialise("firefox");

	}

	@AfterMethod
	public void tearDown() {
		// driver.close();
		driver.quit();
	}

	@Test
	public void TC_001_verifyObsquraTitle() {
		driver.get("https://selenium.obsqurazone.com/index.php");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Obsqura Testing";
		Assert.assertEquals(actualTitle, expectedTitle, "Invalid title found");
	}

	@Test
	public void TC_002_verifySingleInputFieldMessage() {
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement messageField = driver.findElement(By.id("single-input-field"));
		WebElement showButton = driver.findElement(By.id("button-one"));
		WebElement singleInputField = driver.findElement(By.id("message-one"));
		messageField.sendKeys("Testing");
		showButton.click();
		String actualMessage = singleInputField.getText();
		System.out.println(actualMessage);
		String expectedMessage = "Your Message : Testing";
		Assert.assertEquals(actualMessage, expectedMessage, "Invalid message found");

	}

	@Test
	public void TC_003_verifyTwoInputFieldMessage() {
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement valueAField = driver.findElement(By.id("value-a"));
		WebElement valueBField = driver.findElement(By.id("value-b"));
		WebElement getTotalButton = driver.findElement(By.id("button-two"));
		WebElement totalMessage = driver.findElement(By.id("message-two"));
		valueAField.sendKeys("100");
		valueBField.sendKeys("200");
		getTotalButton.click();
		String actualMessage = totalMessage.getText();
		System.out.println(actualMessage);
		String expectedMessage = "Total A + B : 300";
		Assert.assertEquals(actualMessage, expectedMessage, "Invalid message found");
	}

	@Test
	public void TC_004_verifyLocators() throws InterruptedException {
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement firstNameField = driver.findElement(By.id("FirstName"));
		WebElement lastNameField = driver.findElement(By.id("LastName"));
		WebElement emailField = driver.findElement(By.id("Email"));
		WebElement passwordField = driver.findElement(By.id("Password"));
		WebElement confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
		firstNameField.sendKeys("Obsqura");
		lastNameField.sendKeys("demo");
		emailField.sendKeys("anumeenu2610@gmail.com");
		passwordField.sendKeys("test@123");
		confirmPasswordField.sendKeys("test@123");
		WebElement registerButton = driver.findElement(By.name("register-button"));
		registerButton.click();
		Thread.sleep(3000);
		WebElement resultText = driver.findElement(By.className("result"));
		String actualText = resultText.getText();
		System.out.println(actualText);
		String expectedText = "Your registration completed";
		Assert.assertEquals(actualText, expectedText, "Invalid Text found");
	}

	@Test
	public void TC_005_verifyDemoWebShopLoginPage() {
		driver.get("https://demowebshop.tricentis.com/");
		WebElement loginLink = driver.findElement(By.className("ico-login"));
		loginLink.click();
		WebElement emailField = driver.findElement(By.name("Email"));
		WebElement passwordField = driver.findElement(By.name("Password"));

		emailField.sendKeys("anuj@yopmail.com");
		passwordField.sendKeys("test@123");
		// WebElement loginButton=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
		WebElement loginButton = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a"));
		loginButton.click();
	}

	@Test
	public void TC_005_verifyNewToursRegistrationI() {
		driver.get("https://demo.guru99.com/test/newtours/");
		WebElement registerLink = driver.findElement(By.linkText("REGISTER"));
		WebElement registerLink1 = driver.findElement(By.partialLinkText("REGIS"));
		registerLink.click();

		WebElement firstNameField = driver.findElement(By.name("firstName"));
		firstNameField.sendKeys("Anu");
		WebElement lastNameField = driver.findElement(By.name("lastName"));
		lastNameField.sendKeys("meenu");
		WebElement phoneField = driver.findElement(By.name("phone"));
		phoneField.sendKeys("1234567892");
		WebElement emailField = driver.findElement(By.name("userName"));
		emailField.sendKeys("testing@1122");

		WebElement addressField = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input"));
		addressField.sendKeys("XYZ");
		WebElement cityField = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td[2]/input"));
		cityField.sendKeys("Trivandrum");
		WebElement stateField = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input"));
		stateField.sendKeys("Kerala");
		WebElement postalCodeField = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input"));
		postalCodeField.sendKeys("695001");

		WebElement userNameField = driver.findElement(By.cssSelector("#email"));
		userNameField.sendKeys("meenu");
		WebElement passwordField = driver.findElement(By.cssSelector("body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(14) > td:nth-child(2) > input[type=password]"));
		passwordField.sendKeys("anu@123");
		WebElement confirmPasswordField = driver.findElement(By.cssSelector("body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(15) > td:nth-child(2) > input[type=password]"));
		confirmPasswordField.sendKeys("anu@123");
		WebElement submitButton = driver.findElement(By.name("submit"));
		submitButton.click();
	}

	@Test
	public void TC_006_verifyEmptyFieldValidation() {
		driver.get("https://selenium.obsqurazone.com/form-submit.php");
		WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit form']"));
		submitButton.click();

		WebElement firstNameFieldValidation = driver.findElement(By.xpath("//input[@id='validationCustom01']//following-sibling::div[1]"));
		String actualFirstNameValidation = firstNameFieldValidation.getText();
		System.out.println(actualFirstNameValidation);
		String expectedFirstNameValidation = "Please enter First name.";
		Assert.assertEquals(actualFirstNameValidation, expectedFirstNameValidation, "Invalid Message found");

		WebElement lastNameValidation = driver.findElement(By.xpath("//input[@id='validationCustom02']//following-sibling::div[1]"));
		String actualLastNameValidation = lastNameValidation.getText();
		System.out.println(actualLastNameValidation);
		String expectedLastNameValidation = "Please enter Last name.";
		Assert.assertEquals(actualLastNameValidation, expectedLastNameValidation, "Invalid Message found");

		WebElement userNameValidation = driver.findElement(By.xpath("//input[@id='validationCustomUsername']//following-sibling::div[1]"));
		String actualUserNameValidation = userNameValidation.getText();
		System.out.println(actualUserNameValidation);
		String expectedUserNameValidation = "Please choose a username.";
		Assert.assertEquals(actualUserNameValidation, expectedUserNameValidation, "Invalid Message found");

		WebElement cityValidation = driver.findElement(By.xpath("//input[@id='validationCustom03']//following-sibling::div[1]"));
		String actualCityValidation = cityValidation.getText();
		System.out.println(actualCityValidation);
		String expectedCityValidation = "Please provide a valid city.";
		Assert.assertEquals(actualCityValidation, expectedCityValidation, "Invalid Message found");

		WebElement stateValidation = driver.findElement(By.xpath("//input[@id='validationCustom04']//following-sibling::div[1]"));
		String actualStateValidation = stateValidation.getText();
		System.out.println(actualStateValidation);
		String expectedStateValidation = "Please provide a valid state.";
		Assert.assertEquals(actualStateValidation, expectedStateValidation, "Invalid Message found");

		WebElement zipValidation = driver.findElement(By.xpath("//input[@id='validationCustom05']//following-sibling::div[1]"));
		String actualZipValidation = zipValidation.getText();
		System.out.println(actualZipValidation);
		String expectedZipValidation = "Please provide a valid zip.";
		Assert.assertEquals(actualZipValidation, expectedZipValidation, "Invalid Message found");

		WebElement agreeTermValidation = driver.findElement(By.xpath("//label[@class='form-check-label']//following-sibling::div"));
		String actualAgreeTermValidation = agreeTermValidation.getText();
		System.out.println(actualAgreeTermValidation);
		String expectedAgreeTermValidation = "You must agree before submitting.";
		Assert.assertEquals(actualAgreeTermValidation, expectedAgreeTermValidation, "Invalid Message found");

	}

	@Test
	public void TC_007_verifyEmptyStateAndZipCode() {
		driver.get("https://selenium.obsqurazone.com/form-submit.php");
		WebElement firstNameField = driver.findElement(By.xpath("//input[@class='form-control'][1]"));
		WebElement lastNameField = driver.findElement(By.xpath("//input[@id='validationCustom02']"));
		WebElement userNameField = driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
		WebElement cityField = driver.findElement(By.xpath("//input[@id='validationCustom03']"));
		WebElement stateField = driver.findElement(By.xpath("//input[@id='validationCustom04']"));
		WebElement zipField = driver.findElement(By.xpath("//input[@id='validationCustom05']"));
		WebElement checkBoxButton = driver.findElement(By.xpath("//input[@id='invalidCheck']"));
		WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));

		firstNameField.sendKeys("Anu");
		lastNameField.sendKeys("Meenu");
		userNameField.sendKeys("anumeenu");
		cityField.sendKeys("trivandrum");
		checkBoxButton.click();
		submitButton.click();

		WebElement stateValidation = driver.findElement(By.xpath("//input[@id='validationCustom04']//following-sibling::div[1]"));
		WebElement zipValidation = driver.findElement(By.xpath("//input[@id='validationCustom05']//following-sibling::div[1]"));

		String actualZipValidation = zipValidation.getText();
		String actualStateValidation = stateValidation.getText();

		System.out.println(actualStateValidation);
		System.out.println(actualZipValidation);

		String expectedStateValidation = "Please provide a valid state.";
		String expectedZipValidation = "Please provide a valid zip.";

		Assert.assertEquals(actualStateValidation, expectedStateValidation, "Invalid Message found");
		Assert.assertEquals(actualZipValidation, expectedZipValidation, "Invalid Message found");
	}

	@Test
	public void TC_008_verifySuccessfulFormSubmission() {
		driver.get("https://selenium.obsqurazone.com/form-submit.php");
		WebElement firstNameField = driver.findElement(By.xpath("//input[@class='form-control'][1]"));
		WebElement lastNameField = driver.findElement(By.xpath("//input[@id='validationCustom02']"));
		WebElement userNameField = driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
		WebElement cityField = driver.findElement(By.xpath("//input[@id='validationCustom03']"));
		WebElement stateField = driver.findElement(By.xpath("//input[@id='validationCustom04']"));
		WebElement zipField = driver.findElement(By.xpath("//input[@id='validationCustom05']"));
		WebElement checkBoxButton = driver.findElement(By.xpath("//input[@id='invalidCheck']"));
		WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));

		firstNameField.sendKeys("Anu");
		lastNameField.sendKeys("Meenu");
		userNameField.sendKeys("anumeenu");
		cityField.sendKeys("trivandrum");
		stateField.sendKeys("Kerala");
		zipField.sendKeys("695001");
		checkBoxButton.click();
		submitButton.click();

		WebElement formSubmissionValidation = driver.findElement(By.xpath("//div[@id='message-one']"));
		String actualFormSubmissionValidation = formSubmissionValidation.getText();
		System.out.println(actualFormSubmissionValidation);
		String expectedFormSubmissionValidation = "Form has been submitted successfully!";
		Assert.assertEquals(actualFormSubmissionValidation, expectedFormSubmissionValidation, "Invalid message found");
	}

	@Test
	public void TC_009_verifyNewsLetterSubscribtionUsingCssSelector() {
		driver.get("https://demowebshop.tricentis.com");
		WebElement emailField = driver.findElement(By.cssSelector("input#newsletter-email"));
		emailField.sendKeys("anumeenu2610@gmail.com");
		WebElement subscribeButton = driver.findElement(By.cssSelector("input#newsletter-subscribe-button"));
		subscribeButton.click();
	}

	@Test
	public void TC_010_verifyInstantDemoRequestForm() throws InterruptedException {
		driver.get("https://phptravels.com/demo/");
		WebElement firstNameField = driver.findElement(By.cssSelector("input.first_name.input.mb1"));
		WebElement lastNameField = driver.findElement(By.cssSelector("input.last_name.input.mb1"));
		WebElement businessNameField = driver.findElement(By.cssSelector("input.business_name.input.mb1"));
		WebElement emailField = driver.findElement(By.cssSelector("input.email.input.mb1"));
		WebElement numberOne = driver.findElement(By.cssSelector("span#numb1"));
		WebElement numberTwo = driver.findElement(By.cssSelector("span#numb2"));
		WebElement resultField = driver.findElement(By.cssSelector("input#number"));
		WebElement submitButton = driver.findElement(By.cssSelector("button#demo"));

		firstNameField.sendKeys("anu");
		lastNameField.sendKeys("meenu");
		businessNameField.sendKeys("aa");
		emailField.sendKeys("anumeenu2610@gmail.com");

		String num1 = numberOne.getText();
		String num2 = numberTwo.getText();
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
		int n = n1 + n2;
		String actualresult = String.valueOf(n);
		resultField.sendKeys(actualresult);
		Thread.sleep(2000);
		submitButton.click();
		WebElement completedBox = driver.findElement(By.cssSelector("polyline.st0"));
		completedBox.isDisplayed();
	}

	@Test
	public void TC_011_verifyQuitAndClose() {
		driver.get("https://demo.guru99.com/popup.php");
		WebElement clickButton = driver.findElement(By.xpath("//a[text()='Click Here']"));
		clickButton.click();
	}

	@Test
	public void TC_012_verifyNavigateTo() {
		driver.navigate().to("https://demowebshop.tricentis.com");
	}

	@Test
	public void TC_013_verifyRefresh() {
		driver.get("https://demowebshop.tricentis.com");
		WebElement emailField = driver.findElement(By.xpath("//input[@id='newsletter-email']"));
		emailField.sendKeys("anu123@gmail.com");
		driver.navigate().refresh();
	}

	@Test
	public void TC_014_verifyForwardAndBackwardNavigation() throws InterruptedException {
		driver.get("https://demowebshop.tricentis.com");
		WebElement loginLink = driver.findElement(By.xpath("//a[text()='Log in']"));
		loginLink.click();
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
	}

	@Test
	public void TC_015_verifyWebElementCommands() throws InterruptedException {
		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
		WebElement subjectField = driver.findElement(By.xpath("//input[@id='subject']"));
		WebElement descriptionField = driver.findElement(By.xpath("//textarea[@id='description']"));
		WebElement submitButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		subjectField.sendKeys("Selenium");
		descriptionField.sendKeys("Automation testing");
		subjectField.clear();
		String classAttributeValue = subjectField.getAttribute("class");
		System.out.println("Text -----" + classAttributeValue);

		String tagnameValue = subjectField.getTagName();
		System.out.println("Text2 -----" + tagnameValue);

		subjectField.sendKeys("Selenium testing");
		submitButton.click();
		Thread.sleep(10000);
		WebElement validationMessage = driver.findElement(By.xpath("//div[@id='message-one']"));
		String actualValidationMessage = validationMessage.getText();
		String expectedValidationMessage = "Form has been submitted successfully!";
		Assert.assertEquals(actualValidationMessage, expectedValidationMessage, "Invalid Message found");
	}

	@Test
	public void TC_016_verifyIsDisplayed() {
		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
		WebElement subjectField = driver.findElement(By.xpath("//input[@id='subject']"));
		subjectField.sendKeys("Selenium");
		boolean status = subjectField.isDisplayed();
		System.out.println(status);
		Assert.assertTrue(status, "subject field is not displayed");
	}

	@Test
	public void TC_017_verifyIsSelected() {
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		WebElement singleDmeoCheckBox = driver.findElement(By.xpath("//input[@id='gridCheck']"));
		boolean statusbeforeclick = singleDmeoCheckBox.isSelected();
		System.out.println("status-----" + statusbeforeclick);
		Assert.assertFalse(statusbeforeclick, "Checkbox is checked");
		singleDmeoCheckBox.click();
		boolean statusAfterClick = singleDmeoCheckBox.isSelected();
		System.out.println("status after click------" + statusAfterClick);
		Assert.assertTrue(statusAfterClick, "checkbox not checked");
	}

	@Test
	public void TC_018_verifyIsEnabled() {
		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
		WebElement submitButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		boolean submitButtonStatus = submitButton.isEnabled();
		System.out.println("Status-------" + submitButtonStatus);
		Assert.assertTrue(submitButtonStatus, "button is not enabled");
		Point point = submitButton.getLocation(); // to get the location of an element,return type is point
		System.out.println(point.x + "," + point.y);
		Dimension dim = submitButton.getSize(); // to get the size of an element,return type is dimension
		System.out.println(dim.height + "," + dim.width);
		String backgroundColor = submitButton.getCssValue("background-color"); // to get the background color
		System.out.println(backgroundColor);
		WebElement inputelement = driver.findElement(By.tagName("input")); // first element of the input under tagname
		System.out.println(inputelement);
		List<WebElement> elements = driver.findElements(By.tagName("input")); // to print all the elements of input under tagname										
		System.out.println(elements);
		submitButton.submit();
	}

	@Test
	public void TC_019_verifyTheMessageDisplayedInNewTab() {
		driver.get("https://demoqa.com/browser-windows");
		WebElement newTabButton = driver.findElement(By.xpath("//button[@id='tabButton']"));
		boolean newtabbuttonstatus = newTabButton.isEnabled();
		Assert.assertTrue(newtabbuttonstatus, "Button is not enabled");
		newTabButton.click();
		driver.navigate().to("https://demoqa.com/sample");
		WebElement samplePageMessage = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		String actualMessage = samplePageMessage.getText();
		String expectedMessage = "This is a sample page";
		Assert.assertEquals(actualMessage, expectedMessage, "Invalid message found");
	}

	@Test
	public void TC_020_verifyTheMessageDisplayedInNewWindow() {
		driver.get("https://demoqa.com/browser-windows");
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window id=" + parentWindow);
		WebElement newWindowButton = driver.findElement(By.id("windowButton"));
		newWindowButton.click();
		Set<String> handles = driver.getWindowHandles(); // to handle multiple windows including parent window
		System.out.println("windows id= " + handles);
		Iterator<String> handleIds = handles.iterator(); // Set<String> is used so using iterator
		while (handleIds.hasNext()) {
			String childWindow = handleIds.next();
			if (!childWindow.equals(parentWindow))
			{
				driver.switchTo().window(childWindow);
				WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
				String actualText = sampleHeading.getText();
				String expectedText = "This is a sample page";
				Assert.assertEquals(actualText, expectedText, "Invalid message found");
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}
	
	@Test
	public void TC_021_verifyTheMessageDisplayedInNewWindowMessage() {
		driver.get("https://demoqa.com/browser-windows");
		String parentWindow=driver.getWindowHandle();
		System.out.println("parent window---"+parentWindow);
		WebElement newMessageWindowButton=driver.findElement(By.xpath("//button[@id='messageWindowButton']"));
		newMessageWindowButton.click();
		Set<String> handle=driver.getWindowHandles();
		System.out.println("handle id----"+handle);
		Iterator<String> handleIds =handle.iterator();
		while(handleIds.hasNext()) {
			String childwindow=handleIds.next();
			if(!childwindow.equals(parentWindow)) {
				driver.switchTo().window(childwindow);
				//WebElement sampleHeading=driver.findElement(By.id(""));
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}
	
	@Test
	public void TC_022_verifySimpleAlert() {
		driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
		WebElement clickbutton=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		clickbutton.click();
		Alert alert=driver.switchTo().alert();
		String alertText=alert.getText();
		System.out.println(alertText);
		alert.accept();
	}
	
	@Test
	public void TC_023_verifyConfirmAlert() {
		driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
		WebElement clickbutton=driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
		clickbutton.click();
		Alert alert=driver.switchTo().alert();
		String alertText=alert.getText();
		System.out.println(alertText);
		alert.dismiss();
	}
	
	@Test
	public void TC_024_verifyPromptAlert() throws InterruptedException {
		driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
		WebElement promptbox=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		promptbox.click();
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		String alertText=alert.getText();
		System.out.println(alertText);
		alert.sendKeys("alert-prompt");
		alert.accept();
	}
	
	@Test
	public void TC_025_verifyTextInAFrame() {
		driver.get("https://demoqa.com/frames");
		List<WebElement> frames=driver.findElements(By.tagName("iframes"));
		int numberOfFrames=frames.size();         // to find the number of frames
		System.out.println(numberOfFrames);
		//driver.switchTo().frame(3);             //using index
		//driver.switchTo().frame("frame1");      // syntax using name or id(name-copied from id by inspecting)
		WebElement frame=driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame);
		WebElement heading=driver.findElement(By.id("sampleHeading"));
		String headingText=heading.getText();
		System.out.println(headingText);
		//driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void TC_026_verifyRightClick() {
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightclickButton=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions action=new Actions(driver);
		action.contextClick(rightclickButton).build().perform();
		//action.build().perform();
	}
	
	@Test
	public void TC_027_verifyDoubleClick() {
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement doubleclickButton=driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions action=new Actions(driver);
		action.doubleClick(doubleclickButton).build().perform();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	@Test
	public void TC_028_verifyMouseHover() {
		driver.get("https://demoqa.com/menu/");
		WebElement mainItemOne=driver.findElement(By.xpath("//a[text()='Main Item 1']"));
		Actions action=new Actions(driver);
		action.moveToElement(mainItemOne).build().perform();
		//action.moveToElement(mainItemOne,50,50).build().perform();
		//action.moveByOffset(40,50).build().perform();
	}
	
	@Test
	public void TC_029_verifyDragAndDrop() {
		driver.get("https://demoqa.com/droppable");
		WebElement dragmeButton=driver.findElement(By.id("draggable"));
		WebElement dropHereButton=driver.findElement(By.id("droppable"));
		Actions action=new Actions(driver);
		action.dragAndDrop(dragmeButton,dropHereButton).build().perform();
	}
	
	@Test
	public void TC_030_verifyDragAndDropByOffset() {
		driver.get("https://demoqa.com/dragabble");
		WebElement dragMeBox=driver.findElement(By.xpath("//div[@id='dragBox']"));
		Actions action=new Actions(driver);
		action.dragAndDropBy(dragMeBox,100,100).build().perform();
	}
	
	@Test
	public void TC_031_verifyDragableItems() {   // assignment
		driver.get("https://selenium.obsqurazone.com/drag-drop.php");
		WebElement dragMeBox1=driver.findElement(By.xpath("//span[text()='Draggable n°1']"));
		WebElement dragMeBox2=driver.findElement(By.xpath("//span[text()='Draggable n°2']"));
		WebElement dragMeBox3=driver.findElement(By.xpath("//span[text()='Draggable n°3']"));
		WebElement dragMeBox4=driver.findElement(By.xpath("//span[text()='Draggable n°4']"));
		WebElement dropHereBox=driver.findElement(By.xpath("//div[@id='mydropzone']"));
		Actions action=new Actions(driver);
		action.dragAndDrop(dragMeBox1,dropHereBox).build().perform();
		action.dragAndDrop(dragMeBox2,dropHereBox).build().perform();
		action.dragAndDrop(dragMeBox3,dropHereBox).build().perform();
		action.dragAndDrop(dragMeBox4,dropHereBox).build().perform();
	}
}
