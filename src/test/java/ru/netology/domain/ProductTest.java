package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    Product product = new Product(1, "Молоко", 56);

    @Test
    public void matchesTrue() {
        Assertions.assertEquals(true, product.matches("Молоко"));
    }

    @Test
    public void matchesFalseName() {
        Assertions.assertEquals(false, product.matches("Кефир"));
    }


}
