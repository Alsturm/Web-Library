package com.epam.wl.servlets;

import com.epam.wl.entities.User;
import com.epam.wl.services.TestUserService;
import com.epam.wl.services.UserOrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserCancelOrderServlet", urlPatterns = "/usercancel")
public class UserCancelOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int userOrderId = Integer.valueOf(request.getParameter("userOrderId"));
            HttpSession session = request.getSession(false);

            UserOrderService userOrderService = UserOrderService.getInstance();
            userOrderService.deleteNewUserOrder(userOrderId);//(bookId, (User) session.getAttribute("currentSessionUser"));
            request.removeAttribute("userOrderId");
            System.out.println("nededw");

            response.sendRedirect("/userprofile");
        } catch (SQLException | IllegalArgumentException e) {
            request.getRequestDispatcher("errors/error500.html").forward(request, response);
        }
    }
}
