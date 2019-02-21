import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/User.model';

@Component({
  selector: 'app-http',
  templateUrl: './http.component.html',
  styleUrls: ['./http.component.css']
})
export class HttpComponent implements OnInit {
  users:User[] = [];
  user:User;
  unameInput: string = "jvanderzee";

  username:string;
  password:string;
  firstname:string;
  lastname:string;

  constructor(private uService: UserService) { 
    console.log("In http ngInit()");
  }

  ngOnInit() {
    this.getUserByusername();    
    this.getUsers();
  }
  getUsers(){
    this.uService.getUser().subscribe(
      resp => {
        if (resp != null){
          this.users = resp;
          console.log(resp);
        }
        else
        {
          console.error("Error loading Users. Null value loaded");
        }
      }
    );

  }

  getUserByusername(){
    this.uService.getByUsername(this.unameInput).subscribe(
      resp => {
        if (resp.length === 0){
          console.error("Error loading Users. Null value loaded");
          alert("User does not exist");
        }
        else
        {
          this.user = resp[0];
          console.log(resp);
        }
      }
    );

  }

  addUser(){
    let temp = new User();
    temp.username = this.username;
    temp.password = this.password;
    temp.firstname = this.firstname;
    temp.lastname = this.lastname;
    this.uService.addUser(temp).subscribe(
      u => {
        console.log("successfully sent");
        this.users.push(temp);
      }
    );
  }
}
