Feature: Application Login
Scenario: Login with valid credentials
Given Open any Browser
And Navigate To Login Page
When User Enter Username as "ankush.selenium@gmail.com" and password as "Ankush@29" into the fields
And User click on login button
Then Verify User is able to successfully login