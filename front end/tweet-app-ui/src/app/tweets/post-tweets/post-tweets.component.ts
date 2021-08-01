import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/service/user.service';
import { TweetService } from 'src/app/service/tweet.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-post-tweets',
  templateUrl: './post-tweets.component.html',
  styleUrls: ['./post-tweets.component.css']
})
export class PostTweetsComponent implements OnInit {
  "isPost": boolean;
  "isInvalid": boolean;
  constructor(private router: Router,private tweetService:TweetService, private userService: UserService,private route: ActivatedRoute) { }

  ngOnInit(): void {
  }
  onSubmit(form: NgForm) {
    // console.log(form.value.message);
    this.tweetService.postTweets(form.value,this.userService.getLoginId()).subscribe(()=>{
      this.isPost = false;
      setTimeout(() => {
        this.isPost = false;
        this.router.navigate(['/tweet']);
      }, 2000);
    })
  }
}
