package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private int id;
    private String name;
    private int price;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Product product = (Product) o;
//        return id == product.id &&
//                price == product.price &&
//                Objects.equals(name, product.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, price);
//    }


    public boolean matches(String search) {
        if (name.equalsIgnoreCase(search)) {
            return true;
        }
        return false;

    }

}
