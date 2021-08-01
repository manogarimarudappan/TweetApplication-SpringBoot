import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { TweetService } from 'src/app/service/tweet.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-reply-tweet',
  templateUrl: './reply-tweet.component.html',
  styleUrls: ['./reply-tweet.component.css']
})
export class ReplyTweetComponent implements OnInit {
  "replyForm": FormGroup;
  "isPost": boolean ;
  "uploadId":string;
  constructor(private router: Router,private tweetService:TweetService, private userService: UserService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.replyForm = new FormGroup({
      "id":new FormControl(null),
      "message":new FormControl(null,[Validators.required]),
      "postId":new FormControl(null)
    });
    this.route.params.subscribe((params:Params)=>{
      const postId= params['id'];
      this.uploadId=postId;
      this.replyForm.patchValue({
        postId:postId
      })
    })
  
  }
  onSubmitReplyForm(){
    this.tweetService.postReply(this.uploadId,this.userService.getLoginId(),this.replyForm.value).subscribe(()=>{
      this.isPost = false;
      setTimeout(() => {
        this.isPost = false;
        this.router.navigate(['/tweet']);
      }, 2000);
    })
  }

}
