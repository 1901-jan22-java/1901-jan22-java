import { Injectable } from '@angular/core';
import {User} from '../models/User.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/jsom'})
}

@Injectable()
export class UserService {

  url: string = `http://localhost:3000`;
  constructor(private http: HttpClient) {

  }
  public getUser(){
    return this.http.get<User[]>(`${this.url}/users`);
  }
  public getByUsername(username:string){
    return this.http.get<User[]>(`${this.url}/users/?username=${username}`);
  }

  public addUser(user:User){
    return this.http.post(`${this.url}/users`, User, httpOptions);
  }
}
