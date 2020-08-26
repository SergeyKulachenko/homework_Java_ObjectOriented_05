package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {
    private String author;
    private int pages;
    private int publishedYear;


    public Book() {
        super();
    }

    public Book(int id, String name, int price, String author, int pages, int publishedYear) {
        super(id, name, price);
        this.author = author;
        this.pages = pages;
        this.publishedYear = publishedYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                publishedYear == book.publishedYear &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, pages, publishedYear);
    }

    public boolean matches(String search) {
        return super.matches(search) || if (author.equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }

//    public boolean matches(String search) {
//        if (super.matches(search)) {
//            return true;
//        }
//        return if (getAuthor().equalsIgnoreCase(search)) ;
//    }

}
