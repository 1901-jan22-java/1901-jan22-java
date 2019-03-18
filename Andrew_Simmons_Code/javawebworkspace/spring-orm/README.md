#Spring ORM

##### Spring's object relational mapping module. Used to abstract Java Persistence Functionality


* Benefit

	*Easier testing
	*less boiler plate code
	*easy transaction management
	*all configuration is in beans.xml (there is no hibernater.cgf.xml)
	
	
 	*How does it work?
 		* Spring ORM uses contextual sessions (Sessions which exist within the application context) to configure our JPA tool (usually hibernate) with the spring container
 		
 		*In order to do this, we wire a DataSource bean into a SessionFactory bean, which then gets wired into a transactionManager bean and all of our DAOs
 		
 		
 		
 		* @Repository annotation
 			*Annotate DAOs with this, it indicates to the 
 			PersistenceExceptionTranslationPostPRocessor that exception thrown by your DAOs should be interpreted as spring's data access exceptions. This give us more details into what went wrong when an exception is thrown.
 			
 			
 			