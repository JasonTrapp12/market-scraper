import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class KeywordService {
  constructor(private http: HttpClient) { }

  sendKeyword(content: string): Observable<any>{
    const url = 'http://localhost:8080/send-keyword';
    console.log(content)
    return this.http.post(url, content);
  }
}
