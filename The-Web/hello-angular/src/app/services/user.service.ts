import { Injectable } from '@angular/core';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  /*
    Dummy service to understand how these things work
  */

  userList: User[] = [];
  constructor() { }
}
