import { Component, OnInit } from '@angular/core';
import { Tweet } from '../tweet';
import { TweetService } from 'src/app/service/tweet.service';

@Component({
  selector: 'app-tweet',
  templateUrl: './tweet.component.html',
  styleUrls: ['./tweet.component.css']
})
export class TweetComponent implements OnInit {
  'tweet': Tweet[];
  "temporaryList": Tweet[]
  constructor(private tweetService: TweetService) { }

  ngOnInit(): void {
    this.tweetService.getAllTweets().subscribe(data => {
      this.tweet = data;
      this.temporaryList = data;
    })
  

 
  }

}
