package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotFoundException;
import ru.netology.manager.ProductManager;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "Изучаем Java", 1_624, "Бэйтс Берт, Сьерра Кэти");
    Product product2 = new Book(2, "Денискины рассказы", 691, "Виктор Драгунский");
    Product product3 = new Smartphone(3, "Apple iPhone 13", 82_999, "Apple");
    Product product4 = new Smartphone(4, "HUAWEI P50 Pocket White", 89_999, "HUAWEI");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
    }
    @Test
    public void shouldAdd() {
        Product product5 = new Product(5, "Молоко", 56);
        manager.add(product5);
        Product[] expected = {product1, product2, product3, product4, product5};

        Assertions.assertArrayEquals(expected, manager.findAll());

    }

    @Test
    public void shouldAddAlreadyId(){
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            manager.add(product4);
        });
    }

    @Test
    public void shouldFindAll() {
        Product[] expected = {product1, product2, product3, product4};

        Assertions.assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldFindById3() {
        Product expected = product3;

        Assertions.assertEquals(expected, manager.findById(3));
    }

    @Test
    public void shouldFindByIdNoProduct() {
        Product expected = null;

        Assertions.assertEquals(expected, manager.findById(5));
    }

    @Test
    public void shouldRemoveById() {
        Product[] expected = {product1, product3, product4};
        manager.removeById(2);
        Assertions.assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldRemoveByIdNoProduct() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            manager.removeById(5);
        });
    }

}
