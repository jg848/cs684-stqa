import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../login/auth.service';
import { HomeService, NewsResponse } from './home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  news?: NewsResponse;
  welcomeMessage = 'Hello, Please login or signup';
  isLoggedIn = false;

  constructor(private route: ActivatedRoute,
    private router: Router, private homeService: HomeService, private authenticationService: AuthenticationService) { }

  ngOnInit() {

    this.isLoggedIn = this.authenticationService.isUserLoggedIn();
    if (this.isLoggedIn) {
      this.welcomeMessage = 'Welcome ' + this.authenticationService.getLoggedInUserName().toUpperCase();
    }
    this.homeService.getGeneralNews().subscribe((data: NewsResponse) => {
      console.log(data);
      this.news = data;
    })
  }

  refreshPage() {
    window.location.reload();
  }

}