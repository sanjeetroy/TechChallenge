# TechChallenge

There are 9 packages in this project as:
1) beans: 
	It hass all the classes Corresponding to EvemtUrl and the Supporting Classes.
2) common: 
	It has Interfaces Regarding the errorCodes and the the status field for user and Account
	it is same as enum .
3) controller: 
	It has basically two Main Classes and two supporting Classes:
	a) WebController:
			It talks to Util Package and do the mapping from url to Domain Based Classes.
	b) DbController:
			It talks to the service Package and put the data in DB.
4) dao: 
	It handles all the databses operations.
5) domain: 
	It has the domain(model) classes corresponding to the databases.
6) exception: 
	It has all the classes for the custom Exceptions.
7) service: 
	It provides the service to the dao.Every database query must go through this service package.
8) util:  
	it acts as a utility to the Servlets. It talks to the Controller to do the mapping to beans and putting data to databases.

9) web: 
	It has servlets which will talk to the Marketplace . 
