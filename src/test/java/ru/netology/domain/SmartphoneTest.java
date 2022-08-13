package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SmartphoneTest {
    Product product = new Smartphone(4, "P50 Pocket White", 89_999, "HUAWEI");

    @ParameterizedTest
    @CsvSource({
            "true, P50",
            "true, HUAWEI",
            "false, iPhone 13",
            "false, Apple"
    })
    public void matches(boolean expected, String search) {
        Assertions.assertEquals(expected, product.matches(search));
    }
}
