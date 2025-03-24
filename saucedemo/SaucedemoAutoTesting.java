package saucedemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaucedemoAutoTesting {
	WebDriver driver;

	@Test(priority = 1)
	public void browserOpen() {
		// open in different browsers
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
	}

	@Test(priority = 2)
	public void login() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// User hard assertion
		WebElement title = driver.findElement(By.xpath("/html/body/div/div/div[1]"));
		String actTitle = title.getText();
		String expTitle = "Swag Labs";
		Assert.assertEquals(actTitle, expTitle, "Condition Mismatch");

		// login function
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(3000);
		driver.findElement(By.id("login-button")).click();

	}

	@Test(priority = 3)
	public void products() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// User hard assertion
		WebElement title = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
		String actTitle = title.getText();
		String expTitle = "Products";
		Assert.assertEquals(actTitle, expTitle, "Condition Mismatch");

		// product add to cart button click
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(4000);
		// shipping cart button click
		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).click();

	}

	@Test(priority = 4)
	public void cart() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// User hard assertion
		WebElement title = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
		String actTitle = title.getText();
		String expTitle = "Your Cart";
		Assert.assertEquals(actTitle, expTitle, "Condition Mismatch");

		Thread.sleep(4000);
		// checkout button click
		driver.findElement(By.id("checkout")).click();

	}

	@Test(priority = 5)
	public void information() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// User hard assertion
		WebElement title = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
		String actTitle = title.getText();
		String expTitle = "Checkout: Your Information";
		Assert.assertEquals(actTitle, expTitle, "Condition Mismatch");

		// client informations add
		driver.findElement(By.id("first-name")).sendKeys("farhad");
		driver.findElement(By.id("last-name")).sendKeys("mia");
		driver.findElement(By.id("postal-code")).sendKeys("1215");

		Thread.sleep(4000);
		// continue button click
		driver.findElement(By.id("continue")).click();

	}

	@Test(priority = 6)
	public void checkoutOverview() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// User hard assertion
		WebElement title = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
		String actTitle = title.getText();
		String expTitle = "Checkout: Overview";
		Assert.assertEquals(actTitle, expTitle, "Condition Mismatch");

		Thread.sleep(4000);
		// finish button click
		driver.findElement(By.id("finish")).click();

	}

	@Test(priority = 7)
	public void checkoutComplete() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// User hard assertion
		WebElement title = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
		String actTitle = title.getText();
		String expTitle = "Checkout: Complete!";
		Assert.assertEquals(actTitle, expTitle, "Condition Mismatch");

		Thread.sleep(4000);
		// back home button click
		driver.findElement(By.id("back-to-products")).click();

	}

	@Test(priority = 8)
	public void logout() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// User hard assertion
		WebElement title = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
		String actTitle = title.getText();
		String expTitle = "Products";
		Assert.assertEquals(actTitle, expTitle, "Condition Mismatch");

		// burger menu button click
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		// reset app state button click
		driver.findElement(By.id("reset_sidebar_link")).click();
		Thread.sleep(2000);
		// logout button click
		driver.findElement(By.id("logout_sidebar_link")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
