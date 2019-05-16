package TestDemo;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AmazonTest {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().version("2.40").setup();

		/*
		 * ChromeOptions co = new ChromeOptions(); co.addArguments("--headless");
		 */
		WebDriver driver = new ChromeDriver();
		 driver.get("https://www.amazon.in");
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 //Login 
		 driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]")).click();
		 driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("amazontest487@gmail.com");
		 driver.findElement(By.xpath("//input[@id='continue']")).click();
		 driver.findElement(By.xpath("	//input[@id='ap_password']")).sendKeys("user01@123");
		 driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		 
		 
		//input[@id='ap_password']
		 
		 //Entering value in the Search Box
		 driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Iphone 6s");
		 //Clicking Search
		 driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
		 
		 //selecting the first From Result
		Thread.sleep(2000);
		 driver.findElement(By.xpath("(//span[contains(text(),'Apple iPhone 6S (Space Grey, 2GB RAM, 32GB Storage)')])[2]")).click();
		//Window handling
		 
		 Set<String> allwindows=driver.getWindowHandles();
		String MainWindow=driver.getWindowHandle();
		Iterator<String> i1=allwindows.iterator();
		while(i1.hasNext()) {
			
			
			String NewWindow=i1.next();
			
			if(!MainWindow.equalsIgnoreCase(NewWindow)) {
				//Switching to new window
				driver.switchTo().window(NewWindow);
				
driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
				
				driver.findElement(By.xpath("//a[@id='hlb-view-cart-announce']")).click();
				
			String iphoneprice=driver.findElement(By.xpath("//span[@class='a-size-medium a-color-price sc-price sc-white-space-nowrap sc-price-sign']")).getText();
			
			driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']")).click();
			driver.findElement(By.xpath("//a[@id='dropdown1_1']")).click();
			
Thread.sleep(2000);
			String iphoneprice2=driver.findElement(By.xpath("//span[@class='a-size-medium a-color-price sc-price sc-white-space-nowrap sc-price-sign']")).getText();
			System.out.println(iphoneprice);
			System.out.println(iphoneprice2);
			if(!iphoneprice.equals(iphoneprice2)) {
	System.out.println("Pass");
	
	
}else 
	System.out.println("Fail");
			}
		}
		
		driver.quit();
		 
	}
}
