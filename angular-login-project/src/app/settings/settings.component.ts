import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { retry, catchError } from 'rxjs';
import { HomeService, NewsResponse } from '../home/home.service';
import { AuthenticationService } from '../login/auth.service';

export interface Categories {
  id: number;
  name: string;
  checked?: boolean;
}

export class User {
  id?: number;
  username?: string;
  password?: string;
  general?: boolean;
  business?: boolean;
  entertainment?: boolean;
  health?: boolean;
  science?: boolean;
  sports?: boolean;
  technology?: boolean;
}

export class UserResponse {
  message?: string;
  user?: User;
}

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit {

  categories: Categories[] = [];
  isCheckedValid = true;
  categoriesList?: string = '';
  userResponse: UserResponse = new UserResponse;
  errorMessage = 'Select atleast one category';

  constructor(private http: HttpClient, private authenticationService: AuthenticationService, private homeService: HomeService, private router: Router) { }

  get selectedCheckboxList() {
    return this.categories.filter(item => item.checked);
  }

  onSubmit() {
    if (this.selectedCheckboxList.length === 0) {
      this.isCheckedValid = false;
    } else {
      this.isCheckedValid = true;
      this.categoriesList = '';
      this.selectedCheckboxList.forEach(item => {
        this.categoriesList = this.categoriesList + item.name + ',';
      })
      let url = 'http://localhost:8080/news/' + this.authenticationService.getLoggedInUserName().toString() + '/settings?categories=' + this.categoriesList;
      this.http
        .post<NewsResponse>(url, {})
        .pipe(retry(1), catchError(this.homeService.handleError)).subscribe((data: NewsResponse) => {
          
        });
      this.router.navigate(['home'])
        .then(() => {
          window.location.reload();
        });
    }
    this.selectedCheckboxList.forEach((names) => {
      
    });
  }

  clear() {
    this.selectedCheckboxList.forEach(item => {
      item.checked = false;
    })
  }

  ngOnInit(): void {
    this.categories = [
      {
        id: 1,
        name: "General",
        checked: true
      },
      {
        id: 2,
        name: "Business",
        checked: false
      },
      {
        id: 3,
        name: "Entertainment",
        checked: false
      },
      {
        id: 4,
        name: "Health",
        checked: false
      },
      {
        id: 5,
        name: "Science",
        checked: false
      },
      {
        id: 6,
        name: "Sports",
        checked: false
      },
      {
        id: 7,
        name: "Technology",
        checked: false
      },
    ]

    let url = 'http://localhost:8080/users/getUser?username=' + this.authenticationService.getLoggedInUserName().toString();
    this.http
      .get<UserResponse>(url)
      .pipe(retry(1), catchError(this.homeService.handleError)).subscribe((data: UserResponse) => {
        this.userResponse = data;
        if (data.user?.general?.valueOf()) {
          this.categories[0].checked = true;
        } else {
          this.categories[0].checked = false;
        }
        if (data.user?.business?.valueOf()) {
          this.categories[1].checked = true;
        } else {
          this.categories[1].checked = false;
        }
        if (data.user?.entertainment?.valueOf()) {
          this.categories[2].checked = true;
        } else {
          this.categories[2].checked = false;
        }
        if (data.user?.health?.valueOf()) {
          this.categories[3].checked = true;
        } else {
          this.categories[3].checked = false;
        }
        if (data.user?.science?.valueOf()) {
          this.categories[4].checked = true;
        } else {
          this.categories[4].checked = false;
        }
        if (data.user?.sports?.valueOf()) {
          this.categories[5].checked = true;
        } else {
          this.categories[5].checked = false;
        }
        if (data.user?.technology?.valueOf()) {
          this.categories[6].checked = true;
        } else {
          this.categories[6].checked = false;
        }
      });
  }

}
