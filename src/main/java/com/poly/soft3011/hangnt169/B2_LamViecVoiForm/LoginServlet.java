package com.poly.soft3011.hangnt169.B2_LamViecVoiForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {"/login", "/ket-qua"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Truyen du lieu tu servlet => jsp
        // request.setAttribute co 2 tham so
        // TS 1: Ten bien se dung o JSP
        // TS 2: Gia tri muon truyen di : 1 String, 1 List, 1 Doi tuongj...
        request.setAttribute("u1", "Hello world");
        // Chuyen trang
        // C1:
//        request.getRequestDispatcher("/demo/buoi2.jsp").forward(request, response);
        // C2 send Redirect => Chuyen trang
        response.sendRedirect("/demo/buoi2.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay du lieu tu jsp
        String username = request.getParameter("uname");
        String password = request.getParameter("psw");
        // Day du lieu servlet => jsp
        request.setAttribute("n1", username);
        request.setAttribute("n2", password);
        request.getRequestDispatcher("/demo/ket-qua.jsp").forward(request, response);
    }
}
