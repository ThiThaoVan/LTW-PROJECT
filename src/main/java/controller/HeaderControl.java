package controller;

import dao.CategoryDAO;
import entity.Category;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "HeaderControl", value = "/head-control")
public class HeaderControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO cate=new CategoryDAO();
        PrintWriter out = response.getWriter();

        List<Category> listCate= cate.getAllCate();

        for (Category cat : listCate) {
            // trả về đoạn mã html cho từng danh mục
            out.println("<li><a class='dropdown-item' href='product.jsp?pid=" + cat.getId() + "'>" + cat.getName() + "</a></li>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}