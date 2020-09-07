package ru.netology.menager;

import lombok.Data;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;


@Data
public class Menager {
    Repository repository_M = new Repository();

    public void save(Product product) {
        repository_M.save(product);
    }

public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repository_M.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, tmp.length - 1);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

}
