#Feature files are a feature of Cucumber that are written in a special
#language called "Gherkin." Cucumber is a BDD (Behavior Driven Development)
#framework. BDD is an extension of TDD in which test cases are written
#in a way that specifies the desired behavior of the functionality we're
#testing.

#When using Cucumber, test cases are generated from user stories that
#are written in Gherkin. This Gherkin in a feature file (like this one!)
#that has the .feature extension.

#The name and desecription of our User Story (IE a test case)
Feature: Mercury Tours Login
	I wish to login to Mercury Tours using proper credentials.
	
	#This is a general scenario. We create a scenario using the "given",
	#"when", and "then" keywords to define the steps that should be taken
	#when trying to login to Mercury Tours. Cucumber will then generate
	#methods which correspond to each step when we run our feature file.
	#Scenario: Logging Into Mercury Tours
		#Given a user is on the home page of Mercury Tours
		#When a user inputs their username and their password and hits submit
		#Then the user is redirected to the Find Flights page
		
		#NOTE: "And" and "But" do exactly the same thing. The only
		#difference between them is how the reader of the test
		#interprets them.
		
		#A scenario outline imples that we will be using multiple records
		#of data.
	Scenario Outline: Logging Into Mercury Tours
		Given a user is on the home page of Mercury Tours
		When a user inputs their <username>
		And a user inputs their <password>
		But then submits the information
		Then a user is redirected to the Find Flights page
		
		#NOTE: In a data-driven framework, you design your test scripts in
		#a manner in which they take data (e.g. from Excel) and that data
		#determines the number of times the scripts run, as well as with
		#what data.
		
		#In contrast, an alternative to a data-driven framework is a
		#keyword-driven framework in which scripts perform actions as
		#specified by data fed into them. Scripts run only once, but can
		#be customized around what they do, though not with what test
		#data they use. You instead test from a list of predetermined
		#acceptable options. 
		
		#For example, you might have an Excel Sheet which contains 
		#keywords around which you'll test your app. You
		#also have a function library which consists of functions for
		#business logic. When your tests are executed, they will read
		#the keywords from the Excel Sheet and call the functions which
		#contain said keywords.
		
		#NOTE: You can also have a hybrid framework in which you combine
		#the data-driven and keyword-driven approach to testing. This means
		#that users get to determine how the script runs (e.g. around
		#certain keywords) and how many times the tests are run.
		
		#Scenario outlines read from example tables, and in a data-driven
		#fashion execute the whole test for each piece.
		
		Examples:
			|username |password |
			|bobbert  |bobbert  |
			|tropicana|tropicana|
			|goodbye  |hello    |