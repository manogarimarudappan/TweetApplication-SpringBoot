import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../service/user.service';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {
  constructor(private userService:UserService, public router: Router){}
  canActivate():boolean
     {
    if(this.userService.getLoginId()!=null)
      return true;
      else{
        this.router.navigate(['/login']);
        return false;
      }
  }
  
}
