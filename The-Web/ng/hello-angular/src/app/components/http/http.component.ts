import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-http',
  templateUrl: './http.component.html',
  styleUrls: ['./http.component.css']
})
export class HttpComponent implements OnInit {
  users: User[] = [];
  unameInput: string;
  user: User = null;
  notFound = false;
  username: string;
  fn: string;
  ln: string;
  pw: string;

  constructor(private uService: UserService) {
    console.log('IN HTTP COMPONENT CONSTRUCTOR');
   }

  ngOnInit() {
    console.log('IN HTTPCOMPONENT ngOnInit()');
    this.getUsers();
  }

  getUsers() {
    // here we will leverage our user service's get users method 
    // we will SUBSCRIBE to the observable that the method returns
    this.uService.getUsers().subscribe(
      resp => {
        if (resp != null) {
          this.users = resp;
          console.log(resp);
        } else {
          console.error('Error loading users. Null value loaded');
        }
      }
    );
  }

  getUser() {
    this.uService.getByUsername(this.unameInput).subscribe(
      u => {
        if (u.length === 0) {
          console.log('array is empty ');
          this.notFound = true;
        } else {
          console.log(u);
          this.user = u[0];
        }
      }
    );
  }


  addUser() {
    let temp = new User();
    temp.firstName = this.fn;
    temp.lastName = this.ln;
    temp.username = this.username;
    temp.password = this.pw;

    this.uService.addUser(temp).subscribe(
      u => {
        console.log('successfully added user');
        this.users.push(u);
           }
    );
  }


}
