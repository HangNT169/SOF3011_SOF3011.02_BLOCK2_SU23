package com.poly.soft3011.hangnt169.B3_CRUDListFixCung.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hangnt
 */
@Getter
@Setter
@ToString
@NoArgsConstructor // contructor khong tham so
@AllArgsConstructor // contructor full tham so
@Builder // Tao ra 1 contructor tuy y.
//@Data // Cam  <=> Giong viec import *
public class SinhVien {

    private String mssv;

    private String ten;

    private int tuoi;

    private String diaChi;

    private boolean gioiTinh;

}
