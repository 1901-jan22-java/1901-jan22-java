import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user.model';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}) 
};

@Injectable()
export class UserService {

  url: string = 'http://localhost:3000';

  constructor(private http: HttpClient) { }

  public getUsers() {
    return this.http.get<User[]>(`${this.url}/users`);
  }

  public getByUsername(username: string){
    return this.http.get<User[]>(`${this.url}/users?username=${username}`);
  }

  public addUser(user: User){
    return this.http.post<User>(`${this.url}/users`, user, httpOptions);
  }
}
