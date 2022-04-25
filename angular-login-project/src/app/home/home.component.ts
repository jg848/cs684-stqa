import { Component, Directive, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../login/auth.service';
import { Article, HomeService, NewsResponse } from './home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  news?: NewsResponse;
  welcomeMessage = 'Hello, Please login or signup';
  isLoggedIn = false;
  p: number = 1;
  collection: any[] = [];
  homeButton = true;
  generalButton = false;
  businessButton = false;
  entertainmentButton = false;
  healthButton = false;
  scienceButton = false;
  sportsButton = false;
  technologyButton = false;
  category: string = 'home';
  searchText = '';

  constructor(private route: ActivatedRoute,
    private router: Router, private homeService: HomeService, private authenticationService: AuthenticationService) { }

  ngOnInit() {
    let username = 'defaultuser';
    this.isLoggedIn = this.authenticationService.isUserLoggedIn();
    if (this.isLoggedIn) {
      username = this.authenticationService.getLoggedInUserName()
      this.welcomeMessage = 'Welcome ' + username.toUpperCase();
    }
    this.homeService.getUser(username).subscribe((data: any) => {
      this.category = data.message;
    })
    this.homeService.getGeneralNews().subscribe((data: NewsResponse) => {
      this.news = data;
      this.collection = data.articles as any;
    })
  }

  getCategoryNews(category: string) {
    this.category = category;
    if ('home' === category) {
      this.setButtonsToFalse();
      this.homeButton = true;
      return this.ngOnInit();
    }
    if ('general' === category) {
      this.setButtonsToFalse();
      this.generalButton = true;
    }
    if ('business' === category) {
      this.setButtonsToFalse();
      this.businessButton = true;
    }
    if ('entertainment' === category) {
      this.setButtonsToFalse();
      this.entertainmentButton = true;
    }
    if ('health' === category) {
      this.setButtonsToFalse();
      this.healthButton = true;
    }
    if ('science' === category) {
      this.setButtonsToFalse();
      this.scienceButton = true;
    }
    if ('sports' === category) {
      this.setButtonsToFalse();
      this.sportsButton = true;
    }
    if ('technology' === category) {
      this.setButtonsToFalse();
      this.technologyButton = true;
    }
    this.homeService.getCategoryNews(category).subscribe((data: NewsResponse) => {
      this.news = data;
      this.collection = data.articles as any;
    })
  }

  getSearchNews(){
    console.log(this.searchText);
    this.homeService.getSearchResults(this.searchText).subscribe((data: NewsResponse) => {
      this.news = data;
      this.collection = data.articles as any;
    })
  }

  refreshPage() {
    window.location.reload();
  }

  setButtonsToFalse() {
    this.homeButton = false;
    this.generalButton = false;
    this.businessButton = false;
    this.entertainmentButton = false;
    this.healthButton = false;
    this.scienceButton = false;
    this.sportsButton = false;
    this.technologyButton = false;
  }

}