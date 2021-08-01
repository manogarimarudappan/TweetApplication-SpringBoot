import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { NgForm } from '@angular/forms';
import { JsonPipe } from '@angular/common';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  "isLoggedIn": boolean;
  "isInvalid": boolean;
  constructor(private router: Router, private userService: UserService,private route: ActivatedRoute) { }

  ngOnInit(): void {
  }
  onSubmit(form: NgForm) {
    console.log(form);
    console.log("form value", form.value);
    console.log("login id",form.value.loginId);
    this.userService.login(form.value).subscribe(data => {
      this.isLoggedIn = true;
      this.isInvalid = false;
      this.userService.setlogInStatus(this.isLoggedIn);
      this.userService.setLoginId(form.value.loginId);
      setTimeout(() => {
        this.isLoggedIn = false;
        this.router.navigate(['/tweet']);
      }, 2000);

    }, error => {
      console.log("error" + JSON.stringify(error));
      this.isLoggedIn = false;
      this.isInvalid = true;
      this.userService.setlogInStatus(this.isLoggedIn);
    })
  }
}
