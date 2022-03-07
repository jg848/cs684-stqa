import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  // BASE_PATH: 'http://localhost:8080'
  USER_NAME_SESSION_ATTRIBUTE_NAME = ''

  public username: String = '';
  public password: String = '';

  constructor(private http: HttpClient) {

  }

  authenticationService(username: String, password: String) {
    return this.http.post(`http://localhost:8080/users/signin?username=` + username + `&password=` + password, {}).pipe(map((res) => {
      this.username = username;
      this.password = password;
      this.registerSuccessfulLogin(username, password);
    }));
  }

  registrationService(username: String, password: String) {
    return this.http.post(`http://localhost:8080/users/signup?username=` + username + `&password=` + password, {}).pipe(map((res) => {
    }));
  }

  createBasicAuthToken(username: String, password: String) {
    return 'Basic ' + window.btoa(username + ":" + password)
  }

  registerSuccessfulLogin(username: String, password: String) {
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username.valueOf())
  }

  logout() {
    if (this.isUserLoggedIn()) {
      //return this.http.post(`http://localhost:8080/users/signout?username=` + this.getLoggedInUserName(), {}).pipe(map((res) => {
      sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
      this.username = '';
      this.password = '';
      //}));
    } else {
      return;
    }
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    if (user === null || '') return false
    return true
  }

  getLoggedInUserName() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return ''
    return user
  }
}