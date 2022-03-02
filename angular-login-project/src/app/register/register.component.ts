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

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
  }

  handleRegister() {
    if (this.password === this.cpassword) {
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
    }else{
      this.displayError = true;
      this.registerSuccess = false;
      this.errorMessage = 'Passwords must match.'
    }
  }

  check() {
    if (this.password != this.cpassword) {
      this.displayPasswordError = true;
    } else {
      this.displayPasswordError = false;
    }
  }
}