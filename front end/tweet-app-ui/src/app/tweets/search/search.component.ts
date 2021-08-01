import { Component, OnInit } from '@angular/core';
import { TweetService } from 'src/app/service/tweet.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private tweetService:TweetService) { }

  ngOnInit(): void {
  }

  onSearchText(event:any){
    this.tweetService.filter.next({loginId:event.target.value});
  }
}
