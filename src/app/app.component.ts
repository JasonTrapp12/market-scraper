import { Component } from '@angular/core';
import { KeywordService } from './keywordService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private keywordService: KeywordService){}

  title = 'marketplace-scraper';
  keyword = '';


  confirmKeyword() {
    this.keywordService.sendKeyword(this.keyword).subscribe(data=>{
      console.log(data)
    })
  }
}


