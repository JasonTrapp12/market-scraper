package com.example.scraper.services;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ScraperService {
  private String marketplaceURL;

  public ScraperService(){
    this.marketplaceURL = "https://www.facebook.com/marketplace/112762132070166/search/?query=";
  }

  public void scrape(String keyword){
    System.setProperty("webdriver.chrome.driver","C:\\Users\\sowwe\\chromedriver.exe");
    ChromeDriver driver = new ChromeDriver();
    driver.get(marketplaceURL + keyword);
    String page = driver.getPageSource();

    Document doc = Jsoup.parse(page);
    Elements elementsWithKeyword = doc.getElementsContainingOwnText(keyword);

    for (Element element : elementsWithKeyword) {
      //
    }
  }
}
