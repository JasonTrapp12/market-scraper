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
    this.marketplaceURL = "https://www.facebook.com/marketplace/112762132070166/search?deliveryMethod=local_pick_up&query=";
  }

  public void scrape(String keyword){
    System.setProperty("webdriver.chrome.driver","C:\\Users\\sowwe\\chromedriver.exe");
    ChromeDriver driver = new ChromeDriver();
    driver.get(marketplaceURL + keyword);
    String page = driver.getPageSource();

    Document doc = Jsoup.parse(page);

    Elements elements = doc.select("div.x9f619.x78zum5.x1r8uery.xdt5ytf.x1iyjqo2.xs83m0k.x1e558r4.x150jy0e.xnpuxes.x291uyu.x1uepa24.x1iorvi4.xjkvuk6");
    System.out.println(elements.size());
    for(Element element: elements){
      if(!element.text().equals("")){
        Element title = element.selectFirst("span.x1lliihq.x6ikm8r.x10wlt62.x1n2onr6");
        if(title != null){
          String titleString = title.text();
          System.out.println("Title: " + titleString);
        }
        Element price = element.selectFirst("span.x193iq5w.xeuugli.x13faqbe.x1vvkbs.x1xmvt09.x1lliihq.x1s928wv.xhkezso.x1gmr53x.x1cpjm7i.x1fgarty.x1943h6x.xudqn12.x676frb.x1lkfr7t.x1lbecb7.x1s688f.xzsf02u");
        if (price != null) {
          String priceString = price.text();
          System.out.println("Price: " + priceString);
        }
        Element imageElement = element.selectFirst("img.xt7dq6l.xl1xv1r.x6ikm8r.x10wlt62.xh8yej3");
        if (imageElement != null) {
          String imageSrc = imageElement.attr("src");
          System.out.println("Image: " + imageSrc);
        }
      }
    }
  }
}
