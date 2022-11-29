# Data driven from feature file in cucumber :
 

```
	@When("User fill email as {string} and {string} and click on login")
	public void user_fill_email_and_password_and_click_on_login(String username, String password) {
		driver.findElement(By.xpath("//a[normalize-space()='login']")).click();
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		System.out.println("Login Successfully");
	}
```

### dans le features :
```
Feature: Test The login functionality
  Scenario: To login with valid email and valid password 
   Given User open the website and go to login page
   When User fill email as "gunjankaushik" and "Password@123" and click on login
   Then User should navigate to home page
```
