Feature: Test The login functionality
  Scenario: To login with valid email and valid password 
   Given User open the website and go to login page
   When User fill email as "gunjankaushik" and "Password@123" and click on login
   Then User should navigate to home page
