import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const reqMetadata = {
  headers: new HttpHeaders({'Content-Type':'application/json'})
};

@Injectable()
export class UserService {
  /*
    our first use of Dependency Injection!
    here, by declaring a private variable and defining its type,
    we are allowing Angular to inject an instance of an HttpClient so that
    we can use it to send HTTP requests
  */

  url = 'http://localhost:3000';
  constructor(private http:HttpClient) { }

  public getUsers(){
    return this.http.get<User[]>(`${this.url}/users`);
  }

  public getByUsername(username: string){
    return this.http.get<User[]>(`${this.url}/users?username=$(username)`);
  }

  public addUser(user: User){
    return this.http.post<User>(`${this.url}/users`);
  }


}