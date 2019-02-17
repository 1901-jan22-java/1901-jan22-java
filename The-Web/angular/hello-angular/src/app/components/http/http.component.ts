import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/user.model';
import { templateRefExtractor } from '@angular/core/src/render3';

@Component({
  selector: 'app-http',
  templateUrl: './http.component.html',
  styleUrls: ['./http.component.css']
})
export class HttpComponent implements OnInit {

  users: User[] = [];
  usernameInput: string;
  user: User = null;
  username: string;
  fn: string;
  ln: string;
  pw: string;

  constructor(private uService: UserService) { 
    console.log("In http component constructor")
  }

  ngOnInit() {
    console.log("In http component in ngOnInit()");
    this.getUsers();
  }

  getUsers(){
    this.uService.getUsers().subscribe(
      response => {
        if(response != null){
          this.users = response;
          console.log(response);
        } else {
          console.error('Error loading users. Null value loaded');
        }
      }
    );
  }

  getUserByUsername(){
    this.uService.getByUsername(this.usernameInput).subscribe(
      response => {
        if(response.length === 0){
         console.log('No user Found')
        } else {
          console.log(response);
          this.user = response[0];
        }
      }
    )
  }


  addUser(){
    let temp = new User();
    temp.firstName = this.fn;
    temp.lastName = this.ln;
    temp.username = this.username;
    temp.password = this.pw;

    this.uService.addUser(temp).subscribe(
      u => {
        console.log('success');
        this.users.push(u);
      }
    );
  }


}
