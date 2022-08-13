package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProductTest {
    Product product = new Product(1, "Молоко", 56);

    @ParameterizedTest
    @CsvSource({
            "true, Молоко",
            "false, Кефир "
    })
    public void matches(boolean expected, String search) {
        Assertions.assertEquals(expected, product.matches(search));
    }
}
