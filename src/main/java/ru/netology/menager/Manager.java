package ru.netology.menager;

import lombok.Data;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;


@Data
public class Manager {
    private Product[] items = new Product[0];

    public void save(Product item) {//  сохранять Product'ы,
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] searchBy(String text) {
        Repository repository = new Repository();
        Product[] result = new Product[0];
        for (Product product : items) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(items, 0, tmp, 0, result.length + 1);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

//    public boolean matches(Product product, String search) {
//        if (product instanceof Book) {
//            Book book = (Book) product;
//            if (book.getName().equalsIgnoreCase(search)) {
//                return true;
//            }
//            if (book.getAuthor().equalsIgnoreCase(search)) {
//                return true;
//            }
//            return false;
//        }
//        return false;
//    }

    public Product[] searchSm(String text) {
        Repository repository = new Repository();
        Product[] resultSm = new Product[0];
        for (Product product : items) {
            if (matchesSm(product, text)) {
                Product[] tmp = new Product[resultSm.length + 1];
                System.arraycopy(items, 0, tmp, 0, resultSm.length + 1);
                tmp[tmp.length - 1] = product;
                resultSm = tmp;
            }
        }
        return resultSm;
    }

    public boolean matchesSm(Product product, String search) {
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getManufacturer().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
