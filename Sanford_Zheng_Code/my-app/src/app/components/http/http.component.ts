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
  user: User;

  constructor(private service: UserService) {
    console.log('In HTTP Component constructor!')
  }

  ngOnInit() {
    console.log('In HTTPComponent ngOnInit()');
    this.getUsers();
  }

  getUsers() {
    this.service.getUsers().subscribe(
      resp => {
        if (resp != null) {
          this.users = resp;
          console.log(resp);
        } else {
          console.error("Error loading users: NULL value loaded!");
        }
      }
    );
  }

  addUser(){
    let temp = new User();

    temp.id = this.user.id;
    temp.username = this.user.username;
    temp.password = this.user.lastName;
    temp.firstName = this.user.firstName;
    temp.lastName = this.user.lastName;
  }

}
