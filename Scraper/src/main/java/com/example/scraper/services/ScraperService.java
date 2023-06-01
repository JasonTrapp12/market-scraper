package com.example.scraper.services;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ScraperService {
  private String marketplaceURL;

  public ScraperService(){
    this.marketplaceURL = "https://www.facebook.com/marketplace/112762132070166/search/?query=";
  }

  public void scrape(String keyword){
    try{
      Document doc = Jsoup.connect(marketplaceURL + keyword).get();
      System.out.println(marketplaceURL + keyword);
      Elements listings = doc.getElementsByClass("x9f619 x78zum5 x1r8uery xdt5ytf x1iyjqo2 xs83m0k x1e558r4 x150jy0e x1iorvi4 xjkvuk6 xnpuxes x291uyu x1uepa24");
      System.out.println(listings.size());
      for(Element listing: listings){
        System.out.println(listing.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
