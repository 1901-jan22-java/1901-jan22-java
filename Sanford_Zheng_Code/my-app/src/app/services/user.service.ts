import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from 'src/app/models/user.model';

/* A service is a special class that can contain a value, function or collection of behavior and state that is needed by your application. Most services are specialized functions that your application needs in multipl eareas. For example, logging is typically implemented */

const reqMetadata = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url: string = 'http://localhost:3000';
  user: string = '/users';

  constructor(private http: HttpClient) { }

  getUsers() {
    return this.http.get<User[]>(`${this.url}${this.user}`);
  }

  getByUsername(username: string) {
    return this.http.get<User[]>(`${this.url}${this.user}?username=${username}`);
  }

  addUser(user: User) {
    return this.http.post(`${this.url}${this.user}`, user, reqMetadata);
  }

  getById(id: number) {

  }

}
