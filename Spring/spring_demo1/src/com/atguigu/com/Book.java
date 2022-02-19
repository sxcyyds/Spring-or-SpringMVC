package com.atguigu.com;

public class Book {
    private String bname;
    private String price;

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
