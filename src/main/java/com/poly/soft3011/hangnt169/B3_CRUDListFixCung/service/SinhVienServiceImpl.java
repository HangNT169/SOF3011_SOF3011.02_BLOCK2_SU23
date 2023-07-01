package com.poly.soft3011.hangnt169.B3_CRUDListFixCung.service;

import com.poly.soft3011.hangnt169.B3_CRUDListFixCung.entity.SinhVien;
import com.poly.soft3011.hangnt169.B3_CRUDListFixCung.service.impl.SinhVienService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hangnt
 */
public class SinhVienServiceImpl implements SinhVienService {

    private List<SinhVien> listSinhVien = new ArrayList<>();

    public SinhVienServiceImpl() {
        // add 5 phan tu vao day
        listSinhVien.add(new SinhVien("SV1","tuana",20,"abc",true));
        listSinhVien.add(new SinhVien("SV2","tuanb",21,"abc",false));
        listSinhVien.add(new SinhVien("SV3","tuanc",22,"abc",true));
        listSinhVien.add(new SinhVien("SV4","tuand",23,"abc",false));
        listSinhVien.add(new SinhVien("SV5","tuane",24,"abc",true));
    }

    @Override
    public List<SinhVien> getAll() {
        return listSinhVien;
    }
}
