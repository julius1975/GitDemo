Feature: Login into Application

Scenario: Positive test login validation
Given Initialize the browser with chrome
And Navigate to "http://qaclickAcademy.com" site
And Click on login link in home page to land on secured sign in Page
When User enters "ndasijulius@ymail.com" and "Nuvaga1975" and logs in
Then Verify that user is sucessfully logged in