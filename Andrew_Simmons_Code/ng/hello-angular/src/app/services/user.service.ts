import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';

/*
A service is a special class that can contain a value, function or
 collection of behavior and state that is needed by your application.
 Most services are specialized functions that your application needs
 in multiple areas. For example, logging is typically implemented as
 a service because you use it throughout your entire application. Other
 examples, might be a data access service or a service that consumes
 some public API.
Most services are just special classes. You export them like any other
 TypeScript class. The difference appears when you try and create a
 service for use in a class. Most often you only want one instance of
 a service running within your application. This allows for data
 consistency and better performance as you don’t have multiple instances
 of the same functionality being tracked in memory. Typically, you have
 to inject a service into a class for use.
So what is dependency injection? Well, at a high level it is a design
 pattern. The framework that you’re using, in this case Angular, manages
 your class instantiation and provision to other classes for you. You simply
 declare what a class needs as opposed to creating instances yourself.
*/
const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class UserService {


  /*
  our first use of Dependency Injection!
  here, by declaring a private variable and defining its type, we are
  allowing Angular to inject an instance of an HttpClient so that 
  we can use it to send HTTP requests
  */

  url = 'http://localhost:3000';


  constructor(private http: HttpClient) { }

  // returns an observable
  public getUsers() {
    return this.http.get<User[]>(`${this.url}/users`);
  }

  public getByUsername(username: string){
    return this.http.get<User[]>(`${this.url}/users?username=${username}`);
  }


  //POST request
  public addUser(user: User){
    return this.http.post<User>(`${this.url}/users`, user, httpOptions);
  }
}