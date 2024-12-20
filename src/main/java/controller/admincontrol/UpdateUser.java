package controller.admincontrol;

import dao.CustomerDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "UpdateUser", value = "/update-user")
public class UpdateUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = request.getParameter("username");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String phone = request.getParameter("numberPhone");
        String address = request.getParameter("address");
        String role = request.getParameter("role");

        CustomerDAO cusDao = new CustomerDAO();

        int row = cusDao.updateUser(customerName, email, phone, address, role);
        System.out.println(row);
        response.sendRedirect("all-user");


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}