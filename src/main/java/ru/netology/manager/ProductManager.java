package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import java.util.Locale;

public class ProductManager {

    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.add(product);
    }

    public Product[] findAll() {
        return repo.findAll();
    }

    public Product findById(int id) {
        return repo.findById(id);
    }

    public void removeById(int id) {
        repo.removeById(id);
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().toLowerCase(Locale.ROOT).contains(search.toLowerCase())) {
                return true;
            }
            if (book.getAuthor().toLowerCase(Locale.ROOT).contains(search.toLowerCase())) {
                return true;
            }
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().toLowerCase(Locale.ROOT).contains(search.toLowerCase())) {
                return true;
            }
            if (smartphone.getProducer().toLowerCase(Locale.ROOT).contains(search.toLowerCase())) {
                return true;
            }
        }
        return false;
    }



    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

}









