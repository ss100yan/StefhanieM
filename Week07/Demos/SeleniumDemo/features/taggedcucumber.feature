Feature: Mercury Tours Login 2
	I wish to log into Mercury Tours again but with tags.
	
	#In Cucumber, a background can be applied to multiple scenarios.
	Background:
		Given I am at the Mercury Tours home page
		
		#You can use the '@' symbol to apply a custom tag to a scenario
		#of your feature file. Tags are the equivalent of "groups" in
		#TestNG.
		@smoke @stuff
		Scenario: Logging Into Mercury Tours
			When after inputting my username
			And password
			But a user logs in
			Then the user has a great time at the Find Flights page
			
			@regression @stuff
		Scenario Outline:
			When this specific user logs in and inputs both <username> and <password>
			And then goes over to click the login button
			Then the user finds themselves living the dream on the Find Flights page
			
			Examples:
			|username |password |
			|bobbert  |bobbert  |
			|tropicana|tropicana|
			|goodbye  |hello    |