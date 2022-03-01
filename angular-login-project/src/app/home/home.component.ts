import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../login/auth.service';
import { HomeService } from './home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  welcomeMessage = 'Hello, Please login or signup';
  isLoggedIn = false;

  constructor(private route: ActivatedRoute,
    private router: Router, private helloWorldService: HomeService, private authenticationService: AuthenticationService) { }

  ngOnInit() {
    //this.helloWorldService.executeHomeService().subscribe((res: { content: string; }) => {
     // this.welcomeMessage = res.content;
      
    //});
    this.isLoggedIn = this.authenticationService.isUserLoggedIn();
    if(this.isLoggedIn)
      this.welcomeMessage = 'Welcome '+this.authenticationService.username.toUpperCase()
  }
}