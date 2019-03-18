Introduction to [Spring](www.spring.io)

### Topics Covered:

*What is Spring
* Java IoC framework used to build enterprise level applications
* Initially served as simpler, lightweight alternative to standard J2EE

development tools

* Provide a large numbers of helper classes, and tools to abstract standard functionality

* convention over confoguration*


*Depencency Injection
	*We can use XML or annotation to i nject dependencies in Spring. What exactly are depencenies you asl? Anything an object has a HAS - A relationship with.
		*ie. User object HAS A id, username, etc we typically do not inject property values,
		although we can.
		*We typically inject beans into other beans, through a process called bean wiring. For example, a UserService class is dependent upon a UserRepository class. We will not programtically instantiate our User Repo(ie UserRepo repo = new UserRepo();), but instead we will simply declare 
		the dependency and allow our container


### To Make Standard SPRING APP:

*Build simple maven project with required jars
* create spring bean configuration file (Beans.xml)
