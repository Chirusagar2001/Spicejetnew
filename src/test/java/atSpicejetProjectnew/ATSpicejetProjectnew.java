package atSpicejetProjectnew;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ATSpicejetProjectnew {

	public WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@Test(priority = 1)
	public void launchapplication() throws Exception {

		// navigate to the browser
		driver.get("https://www.spicejet.com/");

	}

	@Test(priority = 2)
	public void testSignUpPage() throws Exception {

		driver.findElement(By.xpath("//div[contains(text(),'Signup')]")).click();
		// Get the current window handle (the main window)
		String mainWindowHandle = driver.getWindowHandle();

		// Get all window handles
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainWindowHandle)) {
				// Switch to the sign-in window
				driver.switchTo().window(windowHandle);

				Select title = new Select(driver.findElement(By.xpath("//select[@class='form-control form-select ']")));
				title.selectByVisibleText("Mr");

				driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("chiru");
				driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("some");

				driver.findElement(By.xpath("//input[@placeholder='+91 01234 56789']")).sendKeys("6537355366");

				driver.findElement(By.xpath("//input[@id='dobDate']")).sendKeys("10/10/2001");

				Select nationalitySelect = new Select(
						driver.findElement(By.xpath("//select[@class='form-control form-select']")));
				nationalitySelect.selectByVisibleText("India");

				driver.findElement(By.xpath("//input[@id='email_id']")).sendKeys("some2001@gmail.com");
				driver.findElement(By.xpath("//input[@id='new-password']")).sendKeys("Some@123");
				driver.findElement(By.xpath("//input[@id='c-password']")).sendKeys("Some@123");
				driver.close();
				driver.switchTo().window(mainWindowHandle);

			}
		}
	
	}
	
		@Test(priority = 7)
		public void loginfunctionality() throws Exception {
			
			driver.findElement(By.xpath("(//div[@class='css-76zvg2 r-jwli3a r-ubezar'])[1]")).click();
			
			driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[@class='css-1dbjc4n r-1niwhzg r-1jgb5lz r-r0h9e2 r-13qz1uu']/div[@class='css-1dbjc4n r-1p0dtai r-18u37iz r-1d2f490 r-u8s1d r-zchlnj r-ipm5af']/div[@class='css-1dbjc4n r-14lw9ot r-1p0dtai r-1pcd2l5 r-wk8lta r-u8s1d r-zchlnj r-ipm5af']/div[@class='css-1dbjc4n r-156q2ks']/div[@class='css-1dbjc4n r-wk8lta r-1xcajam']/div[@class='css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-1sncvnh']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n r-1d09ksm r-18u37iz']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n r-1d09ksm r-1inuy60 r-1qxgc49']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj r-p1pxzi']/div[2]"))
					.click();
			
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys("some3003@gmail.com");

			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Some@3001");

			driver.findElement(By.xpath(
					"//div[@class='css-1dbjc4n r-1awozwy r-184aecr r-z2wwpe r-1loqt21 r-18u37iz r-tmtnm0 r-1777fci r-1x0uki6 r-1w50u8q r-ah5dr5 r-1otgn73']"))
					.click();
		}
		
		@Test(priority = 3)
		public void searchforflight() throws Exception {
			Thread.sleep(5000);
			WebElement toInput = driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']//input[@type='text']"));
			toInput.clear();
			toInput.sendKeys("DEL");
			Thread.sleep(1000);

			WebElement fromInput = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']//input[@type='text']"));
			fromInput.clear();
			fromInput.sendKeys("BLR");

			// Click the calendar 
			WebElement datePicker = driver.findElement(By.xpath(
					"//div[@class='css-1dbjc4n r-18u37iz']//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73']//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']"));
			datePicker.click();

			WebElement searchflight = driver.findElement(By.xpath(
					"//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-1w50u8q r-ah5dr5 r-1otgn73']"));
			searchflight.click();
		}
		
		@Test(priority = 4)
		public void proceedtobookingpage() throws Exception {
			
			WebElement proceed = driver.findElement(By.xpath(
					" //div[@class='css-1dbjc4n r-1awozwy r-1xfd6ze r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73']"));
			proceed.click();	
		}
		 
		@Test(priority = 5)
		public void filloutbookingform() throws Exception {
			
			WebElement firstname = driver.findElement(By.xpath("//input[@data-testid='first-inputbox-contact-details']"));
			firstname.clear();
			firstname.sendKeys("sagar");

			WebElement lasstname = driver.findElement(By.xpath("//input[@data-testid='last-inputbox-contact-details']"));
			lasstname.clear();
			lasstname.sendKeys("M S");

			WebElement phno = driver.findElement(By.xpath("//input[@data-testid='contact-number-input-box']"));
			phno.clear();
			phno.sendKeys("7375282549");

			WebElement email = driver
					.findElement(By.xpath("//input[@data-testid='emailAddress-inputbox-contact-details']"));
			email.clear();
			email.sendKeys("chiru3001@gmail.com");

			WebElement town = driver.findElement(By.xpath("//input[@data-testid='city-inputbox-contact-details']"));
			town.clear();
			town.sendKeys("banglore");
			
			WebElement select1 = driver.findElement(By.xpath(
					"//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep r-19h5ruw']//div[@class='css-1dbjc4n r-zso239']"));
			select1.click();

			WebElement con = driver.findElement(By.xpath("//div[@data-testid='traveller-info-continue-cta']"));
			con.click();
 
		}
		
		@Test(priority = 6)
		public void addsonpage() throws Exception {
			WebElement con2 = driver.findElement(By.xpath("(//div[@data-testid='add-ons-continue-footer-button'])[3]"));
			con2.click();

			WebElement selectnow = driver.findElement(By.xpath("//span[@id='selectfrompopup']"));
			selectnow.click();

			WebElement done = driver.findElement(By.xpath(
					"//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-15bsvpr r-1w50u8q r-ah5dr5 r-1otgn73']"));
			done.click();

			Thread.sleep(3000);
			WebElement con3 = driver.findElement(By.xpath("(//div[@data-testid='add-ons-continue-footer-button'])[3]"));
			con3.click();
		}
		@Test(priority = 7)
		public void paymentinformation() throws Exception {
          
			
			//driver.switchTo().frame(driver.findElement(By.name("card_number_iframe_PwjtPTq6s8qAa2fT")));
			driver.switchTo().frame(1);
			WebElement cardholder = driver.findElement(By.xpath("//input[@id='name_on_card']"));
			cardholder.sendKeys("Some");

			
			driver.switchTo().frame(3);
			WebElement expirymonth = driver.findElement(By.xpath("//input[@id='name_on_card']"));
			expirymonth.sendKeys("10");
			
			driver.switchTo().frame(4);
			WebElement cardnumber = driver.findElement(By.xpath("//input[@class='card_number']"));
			cardnumber.sendKeys("1234 5678 9012 3456");
			
			driver.switchTo().frame(5);
			WebElement expiryyear = driver.findElement(By.xpath("//input[@id='name_on_card']"));
			expiryyear.sendKeys("2025");

			driver.switchTo().frame(6);
			WebElement cvv = driver.findElement(By.xpath("//input[@id='name_on_card']"));
			cvv.sendKeys("135");
			
			driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-zso239']")).click();
			
			driver.findElement(By.xpath("//div[@data-testid='common-proceed-to-pay']")).click();
			
			  WebElement popupMessage = driver.findElement(By.
			  xpath("//div[@class='css-1dbjc4n r-1awozwy r-1v8vaea r-eqz5dr r-1777fci r-1wyvozj r-1xcajam r-tyizg9 r-70iriu r-1pozq62]"
			  )); String popupText = popupMessage.getText(); if
			  (popupText.contains("invalid card Details")) { // Handle the error as needed
			  System.out.println("Invalid card number error message: " + popupText); // Add
			 
			  }	  
			  
		}
		@AfterClass
		public void quiteapplication() throws Exception {

			driver.quit();

		}
		
}
