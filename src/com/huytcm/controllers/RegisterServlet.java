package com.huytcm.controllers;

import com.huytcm.dao.UserDao;
import com.huytcm.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");

        UserDao userDao = new UserDao();
        User user = userDao.getUserByUsername(username);
        if (user != null) {
            // not-authenticated user
            request.setAttribute("MSG", "Username already in used!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            boolean isSuccess = userDao.save(user);
            if (isSuccess) {
                response.sendRedirect("login.jsp");
            } else {
                // not-authenticated user
                request.setAttribute("MSG", "Un-expected error! Please try again!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
