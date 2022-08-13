package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SmartphoneTest {
    Product product = new Smartphone(4, "P50 Pocket White", 89_999, "HUAWEI");

    @Test
    public void matchesTrueName() {
        Assertions.assertEquals(true, product.matches("P50"));
    }
    @Test
    public void matchesTrueProducer() {
        Assertions.assertEquals(true, product.matches("HUAWEI"));
    }

    @Test
    public void matchesFalseName() {
        Assertions.assertEquals(false, product.matches("iPhone 13"));
    }

    @Test
    public void matchesFalseProducer() {
        Assertions.assertEquals(false, product.matches("Apple"));
    }
}
