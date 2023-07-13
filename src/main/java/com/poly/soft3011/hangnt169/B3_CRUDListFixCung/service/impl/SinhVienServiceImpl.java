package com.poly.soft3011.hangnt169.B3_CRUDListFixCung.service.impl;

import com.poly.soft3011.hangnt169.B3_CRUDListFixCung.entity.SinhVien;
import com.poly.soft3011.hangnt169.B3_CRUDListFixCung.service.SinhVienService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hangnt
 */
public class SinhVienServiceImpl implements SinhVienService {

    private List<SinhVien> listSinhVien = new ArrayList<>();

    public SinhVienServiceImpl() {
        // add 5 phan tu vao day
        listSinhVien.add(new SinhVien("SV1", "tuana", 20, "abc", true));
        listSinhVien.add(new SinhVien("SV2", "tuanb", 21, "abc", false));
        listSinhVien.add(new SinhVien("SV3", "tuanc", 22, "abc", true));
        listSinhVien.add(new SinhVien("SV4", "tuand", 23, "abc", false));
        listSinhVien.add(new SinhVien("SV5", "tuane", 24, "abc", true));
    }

    @Override
    public List<SinhVien> getAll() {
        return listSinhVien;
    }

    @Override
    public void removeSinhVien(String ma) {
        for (SinhVien sv : listSinhVien) {
            if (sv.getMssv().equalsIgnoreCase(ma)) {
                listSinhVien.remove(sv);
                break;
            }
        }
    }

    @Override
    public SinhVien detailSinhvien(String ma) {
        for (SinhVien sv : listSinhVien) {
            if (sv.getMssv().equalsIgnoreCase(ma)) {
                return sv;
            }
        }
        return null;
    }

    @Override
    public void addSinhVien(SinhVien sv) {
        listSinhVien.add(sv);
    }

    @Override
    public void updateSinhVien(SinhVien sv, String ma) {
        for (int i = 0; i < listSinhVien.size(); i++) {
            if (listSinhVien.get(i).getMssv().equalsIgnoreCase(ma)) {
                listSinhVien.set(i, sv);
                break;
            }
        }
    }
}
