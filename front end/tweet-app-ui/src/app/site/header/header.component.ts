import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private userService: UserService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  getLoginStatus() {
    return this.userService.getLogInStatus();
  }

  logout() {
    this.userService.logout(this.userService.getLoginId()).subscribe(() => {
      this.userService.setlogInStatus(true);
      setTimeout(() => {
        this.router.navigate(['/login']);
      }, 2000);
    },error => {
        console.log("error" + JSON.stringify(error));
      })
  }

}
