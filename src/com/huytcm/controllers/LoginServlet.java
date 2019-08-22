package com.huytcm.controllers;

import com.huytcm.dao.UserDao;
import com.huytcm.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");

        UserDao userDao = new UserDao();
        User user =  userDao.getUserByUsername(username);
        if (user != null && user.checkLogin(username, password)) {
            // authenticated user
            HttpSession session = request.getSession();
            session.setAttribute("USER", user);
            response.sendRedirect("HomeServlet");
        } else {
            // not-authenticated user
            request.setAttribute("MSG", "Login failed!");
            response.sendRedirect("login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
