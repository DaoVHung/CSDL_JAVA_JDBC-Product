package HungBeoo.model.daoImp;
import HungBeoo.model.dao.ProductDAO;
import HungBeoo.model.entity.Product;
import HungBeoo.model.util.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ProductDaoIpm implements ProductDAO<Product, String> {
    public List<Product> searchBetween(Float num1, Float num2){
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> productList = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_SearchBetween(?,?)}");
            callSt.setFloat(1,num1);
            callSt.setFloat(2,num2);
            ResultSet rs= callSt.executeQuery();
            productList = new ArrayList<>();
            while (rs.next()){
                Product p = new Product();
                p.setProductId(rs.getInt("ProductId"));
                p.setProductName(rs.getString("ProductName"));
                p.setPrice(rs.getFloat("Price"));
                p.setCreated(rs.getDate("Created"));
                p.setDescriptions(rs.getString("Descriptions"));
                p.setProductStatus(rs.getBoolean("ProductStatus"));
                productList.add(p);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return productList;
    }
    @Override
    public List<Product> searchProByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> productList = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_SearchByName(?)}");
            callSt.setString(1,name);
            ResultSet rs= callSt.executeQuery();
            productList = new ArrayList<>();
            while (rs.next()){
                Product p = new Product();
                p.setProductId(rs.getInt("ProductId"));
                p.setProductName(rs.getString("ProductName"));
                p.setPrice(rs.getFloat("Price"));
                p.setCreated(rs.getDate("Created"));
                p.setDescriptions(rs.getString("Descriptions"));
                p.setProductStatus(rs.getBoolean("ProductStatus"));
                productList.add(p);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return productList;
    }
    @Override
    public List<Product> getAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> productList = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getAllPro()}");
            ResultSet rs= callSt.executeQuery();
            productList = new ArrayList<>();
            while (rs.next()){
                Product p = new Product();
                p.setProductId(rs.getInt("ProductId"));
                p.setProductName(rs.getString("ProductName"));
                p.setPrice(rs.getFloat("Price"));
                p.setCreated(rs.getDate("Created"));
                p.setDescriptions(rs.getString("Descriptions"));
                p.setProductStatus(rs.getBoolean("ProductStatus"));
                productList.add(p);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return productList;
    }
    public List<Product> getAllBySort() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> productList = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getAllProSort()}");
            ResultSet rs= callSt.executeQuery();
            productList = new ArrayList<>();
            while (rs.next()){
                Product p = new Product();
                p.setProductId(rs.getInt("ProductId"));
                p.setProductName(rs.getString("ProductName"));
                p.setPrice(rs.getFloat("Price"));
                p.setCreated(rs.getDate("Created"));
                p.setDescriptions(rs.getString("Descriptions"));
                p.setProductStatus(rs.getBoolean("ProductStatus"));
                productList.add(p);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return productList;
    }

    @Override
    public boolean save(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_insertPro(?,?,?,?,?,?)}");
//            callSt.setInt(1,product.getProductId());
            callSt.setString(1,product.getProductName());
            callSt.setFloat(2,product.getPrice());
            callSt.setDate(3,new Date(product.getCreated().getTime()));
            callSt.setString(4, product.getDescriptions());
            callSt.setBoolean(5,product.isProductStatus());
            callSt.registerOutParameter(6, Types.INTEGER);
            callSt.execute();
            int cnt = callSt.getInt(6);

        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }

        return result;
    }

    @Override
    public boolean update(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_UpdateBook(?,?,?,?,?,?)}");
            callSt.setInt(1,product.getProductId());
            callSt.setString(2,product.getProductName());
            callSt.setFloat(3,product.getPrice());
            callSt.setDate(4,new Date(product.getCreated().getTime()));
            callSt.setString(5, product.getDescriptions());
            callSt.setBoolean(6,product.isProductStatus());
            callSt.executeUpdate();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }

        return result;
    }

    @Override
    public boolean delete(String id) {
        return Boolean.parseBoolean(null);
    }

    @Override
    public Product getById(String id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_DeleteBook(?)}");
            callSt.setInt(1, id);
          callSt.executeUpdate();

        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }

        return result;    }
    public Product getByName(String name){
        Connection conn = null;
        CallableStatement callSt = null;
        Product pInfo = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_SearchByName(?)}");
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            pInfo = new Product();
            if(rs.next()){
                pInfo.setProductId(rs.getInt("ProductId"));
                pInfo.setProductName(rs.getString("ProductName"));
                pInfo.setPrice(rs.getFloat("Price"));
                pInfo.setCreated(rs.getDate("Created"));
                pInfo.setDescriptions(rs.getString("Drescreptions"));
                pInfo.setProductStatus(rs.getBoolean("ProductStstus"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return pInfo;
    }

    @Override
    public Product getById(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Product pInfo = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_GetBookById(?)}");
            callSt.setInt(1, id);
        ResultSet rs = callSt.executeQuery();
        pInfo = new Product();
        if(rs.next()){
            pInfo.setProductId(rs.getInt("ProductId"));
            pInfo.setProductName(rs.getString("ProductName"));
            pInfo.setPrice(rs.getFloat("Price"));
            pInfo.setCreated(rs.getDate("Created"));
            pInfo.setDescriptions(rs.getString("Descriptions"));
            pInfo.setProductStatus(rs.getBoolean("ProductStstus"));
        }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return pInfo;
    }
}
