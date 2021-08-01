import { Injectable } from '@angular/core';
import { User } from '../user';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  private loginApiUrl = environment.baseUrl;
  "isLoggedIn": boolean;
  "loginId": string;
  constructor(private httpClient: HttpClient) { }

  login(user: User): Observable<any> {
    return this.httpClient.post<void>(this.loginApiUrl + '/login', user);
  }

  register(user: User): Observable<any> {
    return this.httpClient.post<void>(this.loginApiUrl + "/register", user);
  }

  forgetPassword(user: User): Observable<any> {
    return this.httpClient.post<void>(this.loginApiUrl + "/forgot/" + user.loginId, user);
  }

  logout(loginId: string): Observable<any> {
    return this.httpClient.get<void>(this.loginApiUrl + "/logout/" + loginId);
  }

  getLogInStatus() {
    return this.isLoggedIn
  }
  setlogInStatus(login: boolean) {
    this.isLoggedIn = login;
  }

  getLoginId() {
    return this.loginId;
  }
  setLoginId(loginId: string) {
    this.loginId = loginId;
  }
}
