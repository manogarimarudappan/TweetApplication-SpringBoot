import { Component, OnInit } from '@angular/core';

import { UserService } from 'src/app/service/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  "error": String;
  constructor(private userService: UserService, private router: Router, private route: ActivatedRoute) { }
  "signupForm": FormGroup;
  "isRegister": boolean;
  "isExist": boolean

  ngOnInit(): void {
    this.signupForm = new FormGroup({
      "firstName": new FormControl(null, [Validators.required]),
      "lastName": new FormControl(null, [Validators.required]),
      "email": new FormControl(null, [Validators.required, Validators.email]),
      "loginId": new FormControl(null, [Validators.required]),
      "password": new FormControl(null, [Validators.required]),
      "confirmPassword": new FormControl(null, [Validators.required]),
      "contactNumber": new FormControl(null, [Validators.required, Validators.maxLength(10), Validators.minLength(10)])

    });
  }

  onSubmitSignupForm() {
    console.log(this.signupForm.value);

    this.userService.register(this.signupForm.value).subscribe(() => {
      this.isRegister = true;
      setTimeout(() => {
        this.isRegister = false;
        this.router.navigate(['/login']);
      }, 2000);


    }, (responseError) => {
      this.isExist = true;
      setTimeout(() => {
        this.isExist = false;

      }, 2000);
      this.isExist = true;
      this.error = responseError.error.errorMessage;
    })
  }

  passwordCkecks() {
    if (this.signupForm.get('password')?.value != this.signupForm.get('confirmPassword')?.value) {
      return true;
    }
    return false;

  }


}
