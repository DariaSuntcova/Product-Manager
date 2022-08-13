package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BookTest {
    Product product = new Book(1, "Изучаем Java", 1_624, "Бэйтс Берт, Сьерра Кэти");

    @ParameterizedTest
    @CsvSource({
            "true, Java",
            "true, Берт",
            "false, рассказы",
            "false, Драгунский"
    })
    public void matches(boolean expected, String search) {
        Assertions.assertEquals(expected, product.matches(search));
    }
}
