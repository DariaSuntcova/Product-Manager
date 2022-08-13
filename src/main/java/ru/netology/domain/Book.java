package ru.netology.domain;

import java.util.Locale;

public class Book extends Product {
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || author.toLowerCase(Locale.ROOT).contains(search.toLowerCase());
    }
}

