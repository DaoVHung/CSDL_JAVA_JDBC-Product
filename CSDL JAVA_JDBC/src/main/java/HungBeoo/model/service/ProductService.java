package HungBeoo.model.service;

import HungBeoo.model.entity.Product;

import java.util.List;

public interface ProductService<T,V> extends ProductManageService<T,V> {
    boolean delete(Integer id);

    Product getById(Integer id);

    List<T> searchProByName(String name);

    List<T> searchBetween(Float num1, Float num2);

    List<T> getAllBySort();
}
