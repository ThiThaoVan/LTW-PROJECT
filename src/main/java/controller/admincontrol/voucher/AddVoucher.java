package controller.admincontrol.voucher;

import dao.CouponDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "addCouponController", value = "/admin/add-coupon")
public class AddVoucher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String txt_Discount = request.getParameter("discount");

        String msg = "";
        int id = 0;
        if (code.isBlank() || txt_Discount.isBlank()) {
            msg = "Thiếu mã giảm hoặc giá trị của mã";

        } else {
            code = code.toUpperCase();
            double discount = Double.parseDouble(txt_Discount.trim());
            CouponDAO couponDAO = new CouponDAO();

            if (couponDAO.isCouponExist(code)) msg = "Mã giảm giá đã tồn tại";

            id = couponDAO.addCoupon(code, discount);
            if (id >= 1) {
                msg = "Thêm mã thành công";
            }
        }

        response.setContentType("application/json");
        response.getWriter().write("{\"msg\": \"" + msg + "\", \"vId\": " + id + "}");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}