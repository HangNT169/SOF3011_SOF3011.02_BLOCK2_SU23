package com.poly.soft3011.hangnt169.B9_CRUDHibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hangnt
 */
@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private Float price;

    @Column(name = "description")
    private String description;

    // Khoa ngoai
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
    //fetch
    // + fetch Lazy: Khi nao dong cham toi category => MOI CAN LAY
    // + fetch Eager: KHI NAO CUNG TRA RA KET QUA CUA QUAN HE
    // THUONG NEN DUNG LAZY HON EAGER
    // DEFAULT
    // MANY TO ONE => FETCH EAGER
    // ONE TO MANY => FETCH LAZY
}
