package HungBeoo.Controller;

import HungBeoo.model.entity.Product;
import HungBeoo.model.service.ProductService;
import HungBeoo.model.serviceImp.ProductServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductService<Product, String> productService = new ProductServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("delete")) {
            Integer productId = Integer.parseInt(request.getParameter("productId"));
            boolean productDelete = productService.delete(productId);
            if (productDelete){
                getAllProduct(request, response);
            } else {
                request.getRequestDispatcher("view/error.jsp").forward(request, response);
            }

        } else if (action != null && action.equals("update")) {
            Integer productId = Integer.parseInt(request.getParameter("productId"));
            Product productUpdate = productService.getById(productId);
            request.setAttribute("productUpdate", productUpdate);
            request.getRequestDispatcher("view/updateProduct.jsp").forward(request, response);
        } else {
            getAllProduct(request, response);
        }
    }

    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.getAll();
        request.setAttribute("listProduct", productList);
        request.getRequestDispatcher("view/product.jsp").forward(request, response);
    }
    public void getAllBySort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.getAllBySort();
        request.setAttribute("listProduct", productList);
        request.getRequestDispatcher("view/product.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action != null && action.equals("Update")) {
            Product p = new Product();
            p.setProductName(request.getParameter("productName"));
            p.setPrice(Float.parseFloat(request.getParameter("price")));
            p.setDescriptions(request.getParameter("descriptions"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                p.setCreated(sdf.parse(request.getParameter("created")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            p.setProductStatus(Boolean.parseBoolean(request.getParameter("productStatus")));
            p.setProductId(Integer.parseInt(request.getParameter("productId")));

            boolean result = productService.update(p);
            if (result) {
                getAllProduct(request, response);
            } else {
                request.getRequestDispatcher("view/error.jsp").forward(request, response);
            }
        } else if (action != null && action.equals("Create")) {
            Product p = new Product();
            p.setProductName(request.getParameter("productName"));
            p.setPrice(Float.parseFloat(request.getParameter("price")));
            p.setDescriptions(request.getParameter("descriptions"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                p.setCreated(sdf.parse(request.getParameter("created")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            p.setProductStatus(Boolean.parseBoolean(request.getParameter("productStatus")));
            boolean result = productService.save(p);
            if (result) {
                getAllProduct(request, response);
            } else {
                request.getRequestDispatcher("view/error.jsp").forward(request, response);
            }
        } else if (action!=null && action.equals("Search")) {
            String productName = request.getParameter("productName");
            List<Product> productList = productService.searchProByName(productName);
            request.setAttribute("listProduct", productList);
            request.getRequestDispatcher("view/product.jsp").forward(request, response);
        }else if (action!=null && action.equals("SearchPrice")) {
            Float num1 = Float.parseFloat(request.getParameter("num1"));
            Float num2 = Float.parseFloat(request.getParameter("num2"));
            List<Product> productList = productService.searchBetween(num1, num2);
            request.setAttribute("listProduct", productList);
            request.getRequestDispatcher("view/product.jsp").forward(request, response);
        }else if (action!=null && action.equals("Sort By Price")) {
            getAllBySort(request, response);
        }

    }
}
