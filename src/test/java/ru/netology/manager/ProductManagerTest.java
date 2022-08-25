package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;


public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "Изучаем Java", 1_624, "Бэйтс Берт, Сьерра Кэти");
    Product product2 = new Book(2, "Денискины рассказы", 691, "Виктор Драгунский");
    Product product3 = new Smartphone(3, "iPhone 13", 82_999, "Apple");
    Product product4 = new Smartphone(4, "P50 Pocket White", 89_999, "HUAWEI");
    Product product5 = new Book(5, "Волшебная сила искусства", 781, "Виктор Драгунский");
    Product product6 = new Smartphone(4, "iPhone 10Plus", 32_999, "Apple");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
    }

    @Test
    public void shouldSearchByOneProduct() {
        Product[] expected = {product1};

        Assertions.assertArrayEquals(expected, manager.searchBy("Java"));
    }

    @Test
    public void shouldSearchTwoProducts() {
        Product[] expected = {product3, product6};

        Assertions.assertArrayEquals(expected, manager.searchBy("iPhone"));
    }

    @Test
    public void shouldSearchByNoProducts() {
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, manager.searchBy("OPPA"));
    }

}
