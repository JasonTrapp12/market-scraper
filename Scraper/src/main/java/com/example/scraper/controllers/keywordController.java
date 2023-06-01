package com.example.scraper.controllers;
import com.example.scraper.classes.Listing;
import com.example.scraper.services.ScraperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
  public ResponseEntity<List<Listing>> PostKeyword(@RequestBody String keyword){
    this.keyword = keyword;
    System.out.println(keyword);
    List<Listing> listings =  scraperService.scrape(keyword);
    return ResponseEntity.ok(listings);
  }

  public String getKeyword() {
    return this.keyword;
  }
}
