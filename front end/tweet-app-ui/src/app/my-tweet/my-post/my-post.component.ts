import { Component, OnInit } from '@angular/core';
import { Tweet } from 'src/app/tweets/tweet';
import { TweetService } from 'src/app/service/tweet.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-my-post',
  templateUrl: './my-post.component.html',
  styleUrls: ['./my-post.component.css']
})
export class MyPostComponent implements OnInit {
  'tweet': Tweet[];
  "temporaryList": Tweet[];
  "isRemoved":boolean
  constructor(private tweetService: TweetService,private userService:UserService) { }

  ngOnInit(): void {
    this.tweetService.getTweet(this.userService.getLoginId()).subscribe(data=>{
      this.tweet=data;
      this.temporaryList=data;
    })
  }
}
