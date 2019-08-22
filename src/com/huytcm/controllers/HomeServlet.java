package com.huytcm.controllers;

import com.huytcm.dao.PostDao;
import com.huytcm.entities.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageText = request.getParameter("txtPage");
        int page = Integer.parseInt(pageText);
        PostDao postDao = new PostDao();
        List<Post> posts = postDao.getPostAtPage(page);
        request.setAttribute("POSTS", posts);
        response.sendRedirect("index.jsp");
    }
}
