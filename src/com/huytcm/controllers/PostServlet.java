package com.huytcm.controllers;

import com.huytcm.dao.PostDao;
import com.huytcm.dao.PostDetailDao;
import com.huytcm.entities.Post;
import com.huytcm.entities.PostDetail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PostServlet", urlPatterns = "/post")
public class PostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postId = request.getParameter("id");
        if (postId != null) {
            Long id = Long.parseLong(postId);
            System.out.println("id is" + postId + " " + id);
            PostDao postDao = new PostDao();
            Post post = postDao.getPostById(id);
//            PostDetail postDetail = post.getPostDetail();
            request.setAttribute("POST", post);
//            System.out.println(postDetail.getContent());
            request.getRequestDispatcher("/postDetail.jsp").forward(request, response);
        } else {
            // send redirect to error page
        }

    }
}
