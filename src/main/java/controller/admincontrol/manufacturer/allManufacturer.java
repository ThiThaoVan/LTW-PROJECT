package controller.admincontrol.manufacturer;

import dao.ManufacturerDAO;
import entity.Manufacturer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "allManufacturer", value = "/admin/all-manufacturer")
public class allManufacturer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
        // Lấy danh sách nhà sản xuất kèm theo sản phẩm của họ
        List<Manufacturer> manufacturers = manufacturerDAO.getAllManufacturers();

        // Truyền dữ liệu vào JSP
        request.setAttribute("manufacturers", manufacturers);
        request.getRequestDispatcher("/admin/allManufacturer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}



