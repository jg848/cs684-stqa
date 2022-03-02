import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../login/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  username!: String;
  password!: String;
  cpassword!: String;
  errorMessage = 'Registration Failed as User already exists';
  passwordErrorMessage = 'Passwords must match';
  displayError = false;
  displayPasswordError = false;
  successMessage!: String;
  registerSuccess = false;
  authenticate = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
  }

  handleRegister() {
    if(this.username.length<8){
      this.displayError = true;
      this.registerSuccess = false;
      this.errorMessage = 'Username must be atleast 8 characters.'
      this.authenticate = false;
    }else if (!(this.password === this.cpassword)) {
      console.log('else case mismatch');
      this.displayError = true;
      this.registerSuccess = false;
      this.errorMessage = 'Passwords must match.'
      this.authenticate = false;
    }else if (this.password!='/(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&^])[A-Za-z\d$@$!%*#?&]{8,}/'){
      this.displayError = true;
      this.registerSuccess = false;
      this.errorMessage = 'Password invalid format.'
      this.authenticate = false;
    }
    if(this.authenticate){
      this.authenticationService.registrationService(this.username, this.password).subscribe({
        next: (result) => {
          this.registerSuccess = true;
          this.displayError = false;
          this.successMessage = 'Registration Successful.';
          this.router.navigate(['/login']);
        }, error: (err) => {
          this.displayError = true;
          this.registerSuccess = false;
        }
      });
    }
  }

  check() {
    console.log('check')
    if (this.password != this.cpassword) {
      this.displayPasswordError = true;
    } else {
      this.displayPasswordError = false;
    }
  }
}