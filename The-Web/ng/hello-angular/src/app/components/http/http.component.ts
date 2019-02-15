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

  getUser(un:string, pw:string){
    this.uService.getUsers().subscribe(
      resp => {
        if(resp != null){
          for(let e of this.users){
            console.log(e);
          }
        }
      }
    )
  }

}
