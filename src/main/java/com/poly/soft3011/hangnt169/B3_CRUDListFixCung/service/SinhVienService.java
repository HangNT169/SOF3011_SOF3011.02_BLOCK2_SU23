package com.poly.soft3011.hangnt169.B3_CRUDListFixCung.service;

import com.poly.soft3011.hangnt169.B3_CRUDListFixCung.entity.SinhVien;

import java.util.List;

/**
 * @author hangnt
 */
public interface SinhVienService {

    List<SinhVien> getAll();

    void removeSinhVien(String ma);

    SinhVien detailSinhvien(String ma);

    void addSinhVien(SinhVien sv);

    void updateSinhVien(SinhVien sv, String ma);

}
