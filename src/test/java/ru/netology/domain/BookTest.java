package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTest {
    Product product = new Book(1, "Изучаем Java", 1_624, "Бэйтс Берт, Сьерра Кэти");
    @Test
    public void matchesTrueName() {
        Assertions.assertEquals(true, product.matches("Java"));
    }
    @Test
    public void matchesTrueAuthor() {
        Assertions.assertEquals(true, product.matches("Берт"));
    }

    @Test
    public void matchesFalseName() {
        Assertions.assertEquals(false, product.matches("рассказы"));
    }

    @Test
    public void matchesFalseAuthor() {
        Assertions.assertEquals(false, product.matches("Драгунский"));
    }

}
