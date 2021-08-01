import { Component, OnInit, Input } from '@angular/core';
import { Tweet } from 'src/app/tweets/tweet';
import { TweetService } from 'src/app/service/tweet.service';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-my-post-info',
  templateUrl: './my-post-info.component.html',
  styleUrls: ['./my-post-info.component.css']
})
export class MyPostInfoComponent implements OnInit {
  @Input() "tweetList": Tweet;
  "postTime": string;
  "hours": number;
  "minutes": number;
  "seconds": number;
  "isRemoved":boolean;
  constructor(private tweetService: TweetService, private router: Router,private userService:UserService) { }

  ngOnInit(): void {
    let currentDate = new Date();
    let oldDate = new Date(this.tweetList.postTime)


    const totalSeconds = Math.floor(Math.abs((oldDate.getTime() - currentDate.getTime()) / 1000));
   
    const totalMinutes = Math.floor(totalSeconds / 60);
    const totalHours = Math.floor(totalMinutes / 60);
    const totalDays = Math.floor(totalHours / 24);

    this.hours = totalHours - (totalDays * 24);
    this.minutes = totalMinutes - (totalDays * 24 * 60) - (this.hours * 60);
    this.seconds = totalSeconds - (totalDays * 24 * 60 * 60) - (this.hours * 60 * 60) - (this.minutes * 60);

    if ((this.hours > 0 && this.hours < 24) && (this.minutes >= 0 && this.minutes <= 59) && (this.seconds >= 0 && this.seconds <= 59)) {
      this.postTime = this.hours + " hr " + this.minutes + " m " + this.seconds + " s ago" 
    }
    if (this.hours == 0 && this.minutes == 0) {
      this.postTime = this.seconds + " s ago"

    }
    if (this.hours == 0) {
      this.postTime = this.minutes + " m " + this.seconds + " s ago"
    }
    if (this.hours > 24) {
      this.postTime = oldDate.toDateString();
    }
  }
  deleteTweet(id:string){
    this.tweetService.deleteTweet(this.userService.getLoginId(),id).subscribe(()=>{
      this.isRemoved = true;
        this.router.navigate(['/tweet']);      
    })
  }

}
