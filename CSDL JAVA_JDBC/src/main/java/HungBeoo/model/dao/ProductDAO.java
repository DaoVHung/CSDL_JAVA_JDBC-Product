package HungBeoo.model.dao;

import HungBeoo.model.entity.Product;

import java.util.List;

public interface ProductDAO<T,V> extends ProductManage<T,V> {
    List<T> searchProByName(String name);

    boolean delete(Integer id);

    Product getById(Integer id);

    List<T> searchBetween(Float num1, Float num2);

    List<T> getAllBySort();
}
