package ru.netology.domain;

import java.util.Locale;

public class Smartphone extends Product {
    private String producer;

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || producer.toLowerCase(Locale.ROOT).contains(search.toLowerCase());
    }
}
