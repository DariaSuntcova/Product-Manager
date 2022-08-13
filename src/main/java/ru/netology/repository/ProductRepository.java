package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] repo = new Product[0];

    public void add(Product product) {
        Product[] tmp = new Product[repo.length + 1];
        for (int i = 0; i < repo.length; i++) {
            tmp[i] = repo[i];
        }
        tmp[tmp.length - 1] = product;
        repo = tmp;
    }

    public Product[] findAll() {
        return repo;
    }

    public Product findById(int id) {
        for (Product product : repo) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) != null) {
            Product[] tmp = new Product[repo.length - 1];
            int index = 0;
            for (Product product : repo) {
                if (product.getId() != id) {
                    tmp[index] = product;
                    index++;
                }
            }
            repo = tmp;

        } else {
            System.out.println("Такого продукта в репозитории нет");
        }
    }
}

