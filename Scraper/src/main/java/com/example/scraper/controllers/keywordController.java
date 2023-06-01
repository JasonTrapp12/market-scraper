package com.example.scraper.controllers;
import com.example.scraper.services.ScraperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
public class keywordController {
  private String keyword;
  private ScraperService scraperService;

  public keywordController(ScraperService scraperService){
    this.keyword = null;
    this.scraperService = scraperService;
  }

  @PostMapping("/send-keyword")
  public ResponseEntity<String> PostKeyword(@RequestBody String keyword){
    this.keyword = keyword;
    System.out.println(keyword);
    scraperService.scrape(keyword);
    return new ResponseEntity<>("Received Keyword: " + keyword, HttpStatus.OK);
  }

  public String getKeyword() {
    return this.keyword;
  }
}
