package com.poly.soft3011.hangnt169.B3_CRUDListFixCung.controller;

import com.poly.soft3011.hangnt169.B3_CRUDListFixCung.entity.SinhVien;
import com.poly.soft3011.hangnt169.B3_CRUDListFixCung.service.impl.SinhVienServiceImpl;
import com.poly.soft3011.hangnt169.B3_CRUDListFixCung.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
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

    private void viewUpdateSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Can lay gia tu phia view
        String ma = request.getParameter("id");
        SinhVien sv = sinhVienService.detailSinhvien(ma);
        request.setAttribute("sv1",sv);
        request.getRequestDispatcher("/buoi3/update-sinh-vien.jsp").forward(request,response);

    }

    private void detailSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Can lay gia tu phia view
        String ma = request.getParameter("id1");
        SinhVien sv = sinhVienService.detailSinhvien(ma);
        request.setAttribute("sv1",sv);
        request.getRequestDispatcher("/buoi3/detail-sinh-vien.jsp").forward(request,response);
    }

    private void xoaSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Can lay gia tu phia view
        String ma = request.getParameter("ma");
        sinhVienService.removeSinhVien(ma);
        // quay lai trang hien thi
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void viewAddSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/buoi3/add-sinh-vien.jsp");
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

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // B1: Lay toan bo thong tin tren form
        String ma = request.getParameter("mssv");
        String ten1 = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");

        // B2: Tao 1 doi tuong
        SinhVien sv = SinhVien.builder()
                .diaChi(diaChi)
                .ten(ten1)
                .mssv(ma)
                .tuoi(Integer.valueOf(tuoi))
                .gioiTinh(Boolean.valueOf(gioiTinh))
                .build();

        // B3: goi ham trong service
        sinhVienService.addSinhVien(sv);
        // B4: Quay ve trang hien thi
        response.sendRedirect("/sinh-vien/hien-thi");
    }
}
