package com.example.scraper.controllers;
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

  public keywordController(){
    this.keyword = null;
  }

  @PostMapping("/send-keyword")
  public ResponseEntity<String> PostKeyword(@RequestBody String keyword){
    this.keyword = keyword;
    return new ResponseEntity<>("Received Keyword: " + keyword, HttpStatus.OK);
  }

  public String getKeyword() {
    return this.keyword;
  }
}
