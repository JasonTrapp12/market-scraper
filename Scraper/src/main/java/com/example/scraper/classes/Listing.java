package com.example.scraper.classes;

public class Listing {
  private String title;
  private String price;
  private String image;
  private String link;

  public Listing(String title, String price, String image, String link){
    this.title = title;
    this.price = price;
    this.image = image;
    this.link = link;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }
}
