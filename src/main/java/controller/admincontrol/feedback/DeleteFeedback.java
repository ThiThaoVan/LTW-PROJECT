package controller.admincontrol.feedback;

import dao.FeedbackDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "DeleteFeedback", value = "/admin/delete-feedback")
public class DeleteFeedback extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int feedback_id = Integer.parseInt(request.getParameter("fID"));
        FeedbackDAO dao = new FeedbackDAO();
        boolean isSuccess = dao.deleteFeedback(feedback_id) > 0;

        //  response.sendRedirect("all-feedback");
        response.setContentType("application/json");
        response.getWriter().write("{\"isSuccess\":" + isSuccess + "}");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}