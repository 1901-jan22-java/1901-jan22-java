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
  username: string;
  result: User = null;
  un: string;
  pw: string;
  fn: string;
  ln: string;

  constructor(private uService: UserService) {
    console.log('IN HTTP COMPONENT CONSTRUCTOR');
   }

  ngOnInit() {
    console.log('IN HTTP COMPONENT in ngONINIT');
    this.getUsers();
  }

  getUsers() {
    this.uService.getUsers().subscribe(
      resp => {
        if(resp != null) {
          this.users = resp;
          console.log(resp);
        } else {
          console.error('Error loading users. Null value loaded.');
        }
      }
    );
  }

  getUser() {
    console.log(this.username);
    this.uService.getByUsername(this.username).subscribe(
      u => {
        if(u.length !== 0) {
          this.result = u[0];
          console.log(u);
        } else {
          console.error("Not an existing username!");
        }
      }
    );
  }

  addUser() {
    let u = new User();
    u.firstname = this.fn;
    u.lastname = this.ln;
    u.username = this.un;
    u.password = this.pw;
    this.uService.addUser(u).subscribe(
      resp => {
        if(resp != null) {
          console.log("We have successfully added the user.");
          this.getUsers();
        }
      }
    );
  }
}
