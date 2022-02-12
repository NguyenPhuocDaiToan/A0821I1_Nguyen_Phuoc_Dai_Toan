package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreatForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewProduct(request, response);
                break;
            case "searchByName":
                break;
            default:
                listProduct(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "view":
                break;
            case "searchByName":
                searchByName(request, response);
                break;
            default:
                listProduct(request, response);
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.getAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");

        try {
            request.setAttribute("products", products);
            request.setAttribute("message", "home");
            dispatcher.forward(request, response);
        }
        catch (ServletException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreatForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");

        try {
            dispatcher.forward(request, response);
        }
        catch (ServletException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String desc = request.getParameter("desc");
        String manufacture = request.getParameter("manufacture");
        Product product = new Product(0, name, price, desc, manufacture);
        this.productService.save(product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message", "New product was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher;
        try {
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
            dispatcher.forward(request, response);
        }
        catch (ServletException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String desc = request.getParameter("desc");
        String manufacture = request.getParameter("manufacture");

        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;

        if(product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else {
            product.setName(name);
            product.setPrice(price);
            product.setDesc(desc);
            product.setManufacture(manufacture);
            this.productService.update(id, product);
            request.setAttribute("product", product);
            request.setAttribute("message", "Product information was updated");
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//  Delete Product
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;

        if(product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("product/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        }
        catch (ServletException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;

        if(product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else {
            this.productService.remove(id);
            try {
                response.sendRedirect("/products");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("product/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String nameProduct = request.getParameter("nameProduct");
        List<Product> products = this.productService.findByName(nameProduct);
        RequestDispatcher dispatcher;
        request.setAttribute("products", products);
        request.setAttribute("message", "searchByName");
        dispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
