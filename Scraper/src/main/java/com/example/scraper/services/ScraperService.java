package com.example.scraper.services;
import com.example.scraper.classes.Listing;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScraperService {
  private String marketplaceURL;

  public ScraperService(){
    //this.marketplaceURL = "https://www.facebook.com/marketplace/112762132070166/search?daysSinceListed=1&deliveryMethod=local_pick_up&query=";
    this.marketplaceURL = "https://www.facebook.com/marketplace/112762132070166/search?daysSinceListed=1&query=";
  }

  public List<Listing> scrape(String keyword){
    System.setProperty("webdriver.chrome.driver","C:\\Users\\sowwe\\chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    ChromeDriver driver = new ChromeDriver(options);
    driver.get(marketplaceURL + keyword);
    String page = driver.getPageSource();

    Document doc = Jsoup.parse(page);

    Elements elements = doc.select("div.x9f619.x78zum5.x1r8uery.xdt5ytf.x1iyjqo2.xs83m0k.x1e558r4.x150jy0e.xnpuxes.x291uyu.x1uepa24.x1iorvi4.xjkvuk6");
    System.out.println(elements.size());
    List<Listing> listings = new ArrayList<>();
    for(Element element: elements){
      if(!element.text().equals("")){
        String titleString = "title";
        String priceString = "price";
        String imageSrc = "img";
        String link = "link";
        Element title = element.selectFirst("span.x1lliihq.x6ikm8r.x10wlt62.x1n2onr6");
        if(title != null){
          titleString = title.text();
          System.out.println("Title: " + titleString);
        }
        Element price = element.selectFirst("span.x193iq5w.xeuugli.x13faqbe.x1vvkbs.x1xmvt09.x1lliihq.x1s928wv.xhkezso.x1gmr53x.x1cpjm7i.x1fgarty.x1943h6x.xudqn12.x676frb.x1lkfr7t.x1lbecb7.x1s688f.xzsf02u");
        if (price != null) {
          priceString = price.text();
          System.out.println("Price: " + priceString);
        }
        Element imageElement = element.selectFirst("img.xt7dq6l.xl1xv1r.x6ikm8r.x10wlt62.xh8yej3");
        if (imageElement != null) {
          imageSrc = imageElement.attr("src");
          System.out.println("Image: " + imageSrc);
        }
        Element linkElement = element.selectFirst("a.x1i10hfl.xjbqb8w.x6umtig.x1b1mbwd.xaqea5y.xav7gou.x9f619.x1ypdohk.xt0psk2.xe8uvvx.xdj266r.x11i5rnm.xat24cr.x1mh8g0r.xexx8yu.x4uap5.x18d9i69.xkhd6sd.x16tdsg8.x1hl2dhg.xggy1nq.x1a2a7pz.x1heor9g.x1lku1pv");
        if (linkElement != null) {
          link = linkElement.attr("href");
          link = "https://facebook.com" + link;
          System.out.println("Link: " + link);
        }
        Listing listing = new Listing(titleString,priceString,imageSrc,link);
        listings.add(listing);
      }
    }
    return listings;
  }
}
