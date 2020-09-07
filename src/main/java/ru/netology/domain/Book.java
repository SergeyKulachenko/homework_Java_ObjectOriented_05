package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {
    private String author;

    public Book() {
        super();
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Book)) return false;
//        if (!super.equals(o)) return false;
//        Book book = (Book) o;
//        return Objects.equals(author, book.author);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), author);
//    }

//    public boolean matches(String search) {
//        return super.matches(search) || (author.equalsIgnoreCase(search));
//    }


    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return getAuthor().equalsIgnoreCase(search) ;
    }
}
