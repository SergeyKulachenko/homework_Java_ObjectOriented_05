package ru.netology.menager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class MenagerTest {
//    @Mock

    private Repository repository = new Repository();
    //    @InjectMocks
    private Menager menager = new Menager();
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
        //  Menager menager = new Menager();
        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] actual = menager.searcyBy("firstBook");
        Product[] expented = new Product[]{first};
        assertArrayEquals(expented, actual);

    }

    @Test
    public void matchesBook2() {

        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] actual = menager.searcyBy("Author3");
        Product[] expented = new Product[]{third};
        assertArrayEquals(expented, actual);

    }

    @Test
    public void matchesBook3() {

        repository.save(firstS);
        repository.save(secondS);
        repository.save(thirdS);

        Product[] actual = menager.searcyBy("manufacturer3");
        Product[] expented = new Product[]{};
        assertArrayEquals(expented, actual);

    }

//    @Test
//    public void matchesSm1() {
//
//        repository.save(firstS);
//        repository.save(secondS);
//        repository.save(thirdS);
//
//        Product[] actual = menager.searchSm("manufacturer3");
//        Product[] expented = new Product[]{thirdS};
//        assertArrayEquals(expented, actual);
//
//    }
//
//    @Test
//    public void matchesSm2() {
//
//        repository.save(firstS);
//        repository.save(secondS);
//        repository.save(thirdS);
//
//        Product[] actual = menager.searchSm("secondSmart");
//        Product[] expented = new Product[]{secondS};
//        assertArrayEquals(expented, actual);
//
//    }
//
//    @Test
//    public void matchesSm3() {
//
//        repository.save(first);
//        repository.save(second);
//        repository.save(third);
//
//        Product[] actual = menager.searchSm("secondBook");
//        Product[] expented = new Product[]{};
//        assertArrayEquals(expented, actual);
//
//    }

}