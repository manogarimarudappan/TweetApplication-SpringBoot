import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './site/login/login.component';
import { SignupComponent } from './site/signup/signup.component';
import { HeaderComponent } from './site/header/header.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';
import { ForgetPasswordComponent } from './forget-password/forget-password.component';
import { SearchComponent } from './tweets/search/search.component';
import { TweetInfoComponent } from './tweets/tweet-info/tweet-info.component';
import { TweetComponent } from './tweets/tweet/tweet.component';
import { PostTweetsComponent } from './tweets/post-tweets/post-tweets.component';
import { MyPostComponent } from './my-tweet/my-post/my-post.component';
import { MyPostInfoComponent } from './my-tweet/my-post-info/my-post-info.component';
import { MyPostEditComponent } from './my-tweet/my-post-edit/my-post-edit.component';
import { ReplyTweetComponent } from './tweets/reply-tweet/reply-tweet.component';
import { AdminGuard } from './tweets/admin.guard';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'forget', component: ForgetPasswordComponent },
  { path: 'tweet', component: TweetComponent, canActivate: [AdminGuard] },
  { path: 'post', component: PostTweetsComponent, canActivate: [AdminGuard] },
  { path: "my-post", component: MyPostComponent, canActivate: [AdminGuard] },
  { path: '', component: LoginComponent },
  { path: 'edit/:id', component: MyPostEditComponent, canActivate: [AdminGuard] },
  { path: 'reply/:id', component: ReplyTweetComponent, canActivate: [AdminGuard] }


]


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    SignupComponent,
    ForgetPasswordComponent,
    SearchComponent,
    TweetInfoComponent,
    TweetComponent,
    PostTweetsComponent,
    MyPostComponent,
    MyPostInfoComponent,
    MyPostEditComponent,
    ReplyTweetComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
