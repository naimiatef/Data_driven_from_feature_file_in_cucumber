package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	WebDriver driver;

	@Given("User open the website and go to login page")
	public void user_open_the_website_and_go_to_login_page() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/profile");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// avec data driven cucumber

	@When("User fill email as {string} and {string} and click on login")
	public void user_fill_email_and_password_and_click_on_login(String username, String password) {
		driver.findElement(By.xpath("//a[normalize-space()='login']")).click();
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		System.out.println("Login Successfully");
	}

	// Méthode 2 : avec DataTable

	/*
	 * dans Login.feature : When User fill email as username and password and click
	 * on login |gunjankaushik | Password@123 |
	 * 
	 * @When("User fill email as username and password and click on login") public
	 * void user_fill_email_and_password_and_click_on_login(DataTable wheData) {
	 * driver.findElement(By.xpath("//a[normalize-space()='login']")).click();
	 * driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(wheData.cell
	 * (0, 0));
	 * driver.findElement(By.xpath("//input[@id='password']")).sendKeys(wheData.cell
	 * (0, 1)); driver.findElement(By.id("login")).click();
	 * System.out.println("Login Successfully"); }
	 */

	@Then("User should navigate to home page")
	public void user_should_navigate_to_home_page() {
		driver.findElement(By.xpath("//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']")).click();
		System.out.println("LogOut Successfully");

	}
}
