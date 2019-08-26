package com.huytcm.controllers;

import com.huytcm.dao.PostDao;
import com.huytcm.entities.Post;
import com.huytcm.entities.PostDetail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditorServlet", urlPatterns = "/editor")
public class EditorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txtTitle = request.getParameter("txtTitle");
        String content = request.getParameter("content");
        if (txtTitle != null) {
            PostDao postDao = new PostDao();
            boolean isSuccess = postDao.saveNewPost(txtTitle, content);
            if (isSuccess) {
                System.out.println("save success");
            } else {
                System.out.println("save failed");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("go to editor page");
        request.getRequestDispatcher("/editor.jsp").forward(request, response);
    }
}
