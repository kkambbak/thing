package org.example.quotes.entity;

public class Quotes {
    private int quotesNum;
    private String quotes;
    private String author;

    public int getQuotesNum() {
        return quotesNum;
    }

    public void setQuotesNum(int quotesNum) {
        this.quotesNum = quotesNum;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Quotes(int quotesNum, String quotes, String author) {
        this.quotesNum = quotesNum;
        this.quotes = quotes;
        this.author = author;
    }
}
