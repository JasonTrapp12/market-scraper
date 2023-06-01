import { Component } from '@angular/core';
import { KeywordService } from './keywordService';
import { Listing } from './listing.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private keywordService: KeywordService){}

  title = 'marketplace-scraper';
  keyword = '';
  listings: Listing[] = [];

  confirmKeyword() {
    this.keywordService.sendKeyword(this.keyword).subscribe(data=>{
      console.log(data);
      this.listings = data;
      console.log(this.listings)
    })
  }

  goToLink(url: string){
    window.open(url, "_blank");
}

}


