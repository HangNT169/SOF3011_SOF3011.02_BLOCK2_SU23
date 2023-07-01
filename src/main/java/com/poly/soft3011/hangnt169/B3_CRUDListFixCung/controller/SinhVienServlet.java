package com.poly.soft3011.hangnt169.B3_CRUDListFixCung.controller;

import com.poly.soft3011.hangnt169.B3_CRUDListFixCung.entity.SinhVien;
import com.poly.soft3011.hangnt169.B3_CRUDListFixCung.service.SinhVienServiceImpl;
import com.poly.soft3011.hangnt169.B3_CRUDListFixCung.service.impl.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", value = {
        "/sinh-vien/hien-thi", // GET
        "/sinh-vien/search",   // GET
        "/sinh-vien/add",     // POST
        "/sinh-vien/view-add",  // GET
        "/sinh-vien/remove",    // GET
        "/sinh-vien/detail",    // GET
        "/sinh-vien/update",    // POST
        "/sinh-vien/view-update"  // GET
})
public class SinhVienServlet extends HttpServlet {

    private SinhVienService sinhVienService = new SinhVienServiceImpl();
    private List<SinhVien>lists = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            // lam chuc nang hien thi
            this.hienThiSinhVien(request, response);
        } else if (uri.contains("search")) {
            // Lam chuc nang search
            this.searchSinhVien(request, response);
        } else if (uri.contains("view-add")) {
            // hien thi view add
            this.viewAddSinhVien(request, response);
        } else if (uri.contains("remove")) {
            // lam chuc nang xoa
            this.xoaSinhVien(request, response);
        } else if (uri.contains("detail")) {
            //lam chuc nang detai
            this.detailSinhVien(request, response);
        } else {
            //lam chuc nang view update
            this.viewUpdateSinhVien(request, response);
        }
    }

    private void viewUpdateSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void xoaSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAddSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = sinhVienService.getAll(); // co 5 phan tu
        // Truyen servlet => jsp
        request.setAttribute("sinhViens",lists);
        request.getRequestDispatcher("/buoi3/sinhviens.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            //lam chuc nang them
            this.addSinhVien(request, response);
        } else {
            //lam chuc nang update
            this.updateSinhVien(request, response);
        }
    }

    private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }
}
