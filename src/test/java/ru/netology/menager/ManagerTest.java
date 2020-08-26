package ru.netology.menager;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class ManagerTest {
//    @Mock

    //   private Repository repository;
//    @InjectMocks
    private Manager manager = new Manager();
    private Book first = new Book(1, "firstBook", 1, "Author1", 1, 1);
    private Book second = new Book(2, "secondBook", 1, "Author2", 1, 1);
    private Book third = new Book(2, "thirdBook", 1, "Author3", 1, 1);

    private Smartphone firstS = new Smartphone(1, "firstSmart", 1, "manufacturer1");
    private Smartphone secondS = new Smartphone(2, "secondSmart", 1, "manufacturer2");
    private Smartphone thirdS = new Smartphone(2, "thirdSmart", 1, "manufacturer3");

    @Test
    public void matchesBoook1() {
//        Product[] returned = new Product[]{first, second,third};
//        doReturn(returned).when(repository).findAll();
        //  Manager manager = new Manager();
        manager.save(first);
        manager.save(second);
        manager.save(third);

        Product[] actual = manager.searchBy("firstBook");
        Product[] expented = new Product[]{first};
        assertArrayEquals(expented, actual);

    }

    @Test
    public void matchesBook2() {

        manager.save(first);
        manager.save(second);
        manager.save(third);

        Product[] actual = manager.searchBy("Author3");
        Product[] expented = new Product[]{third};
        assertArrayEquals(expented, actual);

    }

    @Test
    public void matchesBook3() {

        manager.save(firstS);
        manager.save(secondS);
        manager.save(thirdS);

        Product[] actual = manager.searchBy("manufacturer3");
        Product[] expented = new Product[]{};
        assertArrayEquals(expented, actual);

    }

    @Test
    public void matchesSm1() {

        manager.save(firstS);
        manager.save(secondS);
        manager.save(thirdS);

        Product[] actual = manager.searchSm("manufacturer3");
        Product[] expented = new Product[]{thirdS};
        assertArrayEquals(expented, actual);

    }

    @Test
    public void matchesSm2() {

        manager.save(firstS);
        manager.save(secondS);
        manager.save(thirdS);

        Product[] actual = manager.searchSm("secondSmart");
        Product[] expented = new Product[]{secondS};
        assertArrayEquals(expented, actual);

    }

    @Test
    public void matchesSm3() {

        manager.save(first);
        manager.save(second);
        manager.save(third);

        Product[] actual = manager.searchSm("secondBook");
        Product[] expented = new Product[]{};
        assertArrayEquals(expented, actual);

    }

}