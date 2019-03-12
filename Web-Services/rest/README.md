# REST
#### _REpresentational State Transfer_

A RESTful web application exposes information abuot itself in the form of information about its resources. It also enables the client to take actions on those resources, such as create new resources (ie create a new user) or exchange existing resources (ie change username)

An important term to understand when it comes to REST is __resource__ which is any object the API can provide information on. Each resource has a unique identifier. The identifier can be a name or a number. 

In order for your API to be RESTful, you must follow a set of constraints: 
* __Client-Server Separation__
	* The _client_ is the person or software using(consuming) the API
	* The _server_ is the person or software producing(exposing) the API
	* This constraint requires that the client and server act independently, on their own, and that the interactions between them is only in the form of requests from the client to the server and responses from the server to the client. 
	* The server simply waits for the requests from the client(s) and does not sending information on its own. 
* __Uniform Interface__
	* _"Once a developer becomes familiar with one of your API, they should be able to follow the similar approach for other APIs"_
	* The request to the server has to include a resource identifier
	* The response from the server includes enough information for the client to manipulate the resource 
	* Each request to the API contains all the information that the server needs to perform the request
	* Whenever releavnt, a resource should contain links pointing to relative URIs to getch related information -- Hypermedia as the engine of application state (HATEOAS - yes, weird acronym I know. Let's discuss) 
		* By application we mean web app that the server has deployed 
		* Hypermedia - the hyperlinks, or simply links, that the server can include in the response 
		* Together, we mean that the server can inform the client, in a response, of the ways to change the state of the web application. 



###### Sources and Important Readings 
* [Representational State Transfer(REST) by Fielding](https://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm)
* [What is REST - A Simple Explanation for Beginners](https://medium.com/extend/what-is-rest-a-simple-explanation-for-beginners-part-1-introduction-b4a072f8740f)
* [REST API Tutorial](restfulapi.net/)