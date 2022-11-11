package HungBeoo.model.serviceImp;

import HungBeoo.model.dao.ProductDAO;
import HungBeoo.model.daoImp.ProductDaoIpm;
import HungBeoo.model.entity.Product;
import HungBeoo.model.service.ProductService;

import java.util.List;

public class ProductServiceImp implements ProductService<Product, String> {
    private ProductDAO<Product, String> stringProductDAO = new ProductDaoIpm();
    @Override
    public List<Product> getAll() {
        return stringProductDAO.getAll();
    }
    public List<Product> getAllBySort() {
        return stringProductDAO.getAllBySort();
    }


    @Override
    public boolean save(Product product) {
        return stringProductDAO.save(product);
    }

    @Override
    public boolean update(Product product) {
        return stringProductDAO.update(product);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Product getById(String id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return stringProductDAO.delete(id);
    }

    @Override
    public Product getById(Integer id) {
        return stringProductDAO.getById(id);
    }

    @Override
    public List<Product> searchProByName(String name) {
        return stringProductDAO.searchProByName(name);
    }
    public List<Product> searchBetween(Float num1, Float num2) {
        return stringProductDAO.searchBetween(num1,num2);
    }
}

