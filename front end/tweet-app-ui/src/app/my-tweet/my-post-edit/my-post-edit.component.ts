import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { TweetService } from 'src/app/service/tweet.service';
import { UserService } from 'src/app/service/user.service';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';
import { Tweet } from 'src/app/tweets/tweet';

@Component({
  selector: 'app-my-post-edit',
  templateUrl: './my-post-edit.component.html',
  styleUrls: ['./my-post-edit.component.css']
})
export class MyPostEditComponent implements OnInit {
  "editupForm": FormGroup;
  "isPost": boolean ;
  "uploadId":string;

  constructor(private router: Router,private tweetService:TweetService, private userService: UserService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.editupForm = new FormGroup({
      "id":new FormControl(null),
      "message":new FormControl(null,[Validators.required])
    });
    this.route.params.subscribe((params:Params)=>{
      const postId= params['id'];
      this.uploadId=postId;
      this.tweetService.getPost(postId).subscribe((tweet:Tweet)=>{
        if(tweet){
          this.editupForm.patchValue({
            id:postId,
            message:tweet.message
          })
        }
      })
    })
    
  }

  onSubmitEditupForm(){
    this.tweetService.updateTweet(this.userService.getLoginId(),this.uploadId,this.editupForm.value).subscribe(data=>{
      this.isPost=true;
      setTimeout(() => {
        this.isPost = false;
        this.router.navigate(['/my-post']);
      }, 2000);
    })
  }

  
}
