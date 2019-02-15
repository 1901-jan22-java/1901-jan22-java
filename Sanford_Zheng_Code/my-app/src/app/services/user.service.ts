import { Injectable } from '@angular/core';

import { User } from '../models/user.model';
/*
  A service is a special class that can contain a value, function or collection of behavior and state that is needed by your application. Most services are specialized functions that your application needs in multipl eareas. For example, logging is typically implemented
*/

@Injectable({
  providedIn: 'root'
})
export class UserService {

  userList: User[];

  constructor() { }
}
