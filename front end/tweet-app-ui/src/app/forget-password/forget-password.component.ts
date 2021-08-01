import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../service/user.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./forget-password.component.css']
})
export class ForgetPasswordComponent implements OnInit {
  "ispasswordChanged":boolean;
  "isInvalid": boolean;
  constructor(private userService: UserService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  onForget(form:NgForm){
    console.log(form.value);
    this.userService.forgetPassword(form.value).subscribe(()=>{
      this.ispasswordChanged=true;
      setTimeout(() => {
        this.ispasswordChanged = false;
        this.router.navigate(['/login']);
      }, 2000);
    }, error => {
      this.isInvalid=true;
      console.log("error" + JSON.stringify(error));
    })
  }

}
