package com.example.foundit;

public class Product {
   private String title, author, isbn, seller, condition;
   private int price;
   private String imageUrl;

   public Product(String title, String author, String isbn, String seller, String condition, int price){
       this.title = title;
       this.author = author;
       this.isbn = isbn;
       this.seller = seller;
       this.condition = condition;
       this.price = price;
       //this.imageUrl = imageUrl;

   }

    public Product(String title, String author, String isbn, String seller, String condition, int price, String imageUrl) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.seller = seller;
        this.condition = condition;
        this.price = price;
        this.imageUrl = imageUrl;
    }

   public String getTitle(){
       return title;
   }
   public void setTitle(String title){
        this.title = title;
   }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getSeller(){
        return seller;
    }
    public void setSeller(String seller){
        this.seller = seller;
    }

    public String getCondition(){
        return condition;
    }
    public void setCondition(String condition){
        this.condition = condition;
    }

    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }

    public String getImageUrl(){
       return imageUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
}
