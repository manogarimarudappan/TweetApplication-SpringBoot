import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Tweet } from '../tweets/tweet';
import { Observable, Subject } from 'rxjs';
import { ReplyTweets } from '../tweets/reply-tweets';
@Injectable({
  providedIn: 'root'
})
export class TweetService {
  private loginApiUrl = environment.baseUrl;
  filter = new Subject();
  constructor(private httpClient: HttpClient) { }

  getAllTweets(): Observable<Tweet[]> {
    return this.httpClient.get<Tweet[]>(this.loginApiUrl + "/all");
  }

  postTweets(post: Tweet, loginId: string): Observable<any> {
    return this.httpClient.post<void>(this.loginApiUrl + "/" + loginId + "/" + "add", post);
  }

  getTweet(loginId: string): Observable<any> {
    return this.httpClient.get<Tweet[]>(this.loginApiUrl + "/" + loginId);
  }

  updateTweet(loginId: string, postId: string, post: Tweet): Observable<any> {
    return this.httpClient.put<void>(this.loginApiUrl + "/" + loginId + "/update/" + postId, post);

  }
  deleteTweet(loginId: string, postId: string): Observable<any> {
    return this.httpClient.delete<void>(this.loginApiUrl + "/" + loginId + "/delete/" + postId);
  }

  getPost(id: string): Observable<any> {
    return this.httpClient.get<Tweet>(this.loginApiUrl + "/post/" + id);
  }

  getReply(id: string, loginId: string): Observable<any> {
    return this.httpClient.get<ReplyTweets[]>(this.loginApiUrl + "/" + loginId + "/view-reply/" + id);
  }

 

  postReply(id: string, loginId: string, replyTweets: ReplyTweets): Observable<any> {
    return this.httpClient.post<void>(this.loginApiUrl + "/" + loginId + "/reply/" + id, replyTweets);
  }

  postLike(id: string, loginId: string):Observable<any>{
    return this.httpClient.get<void>(this.loginApiUrl+"/"+loginId+"/like/"+id)
  }
}

