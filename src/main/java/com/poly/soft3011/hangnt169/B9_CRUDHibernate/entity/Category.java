package com.poly.soft3011.hangnt169.B9_CRUDHibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author hangnt
 */
@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Category {

    // Khoa chinh
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tu tang
    private Long id1111;

    // 1 cot binh thuong
    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;

}
//    @OneToMany
//    private List<Product>products;
/**
 * Java 3: JDBC => Truy van tren SQL
 * Java 4: Hibernate
 *  => Truy van tren HQL(Hibernate Query Language)
 *  => Tuc la se truy van truc tiep tren thuc the (entity)
 * Java 5: JPA
 *  => JPQL
 *  ORM(Object Relationship Mapping)
 *  varchar/nvarchar => String
 *  int => int /Integer
 *  float => float / Float
 *  bit => boolean /Boolean
 *  bigint => long/Long
 *  uniqueidentifier => String/UUID => tu gen newID()
 *  ...
 *  1 cột SQL(table)
 *      + khoá chính
 *      + khoá ngoại
 *      + column bình thường
 *   Quan hệ 2 bảng
 *      - 1 - 1(One to One)
 *      - 1 - N(One to Many)
 *      - N - 1(Many to One)
 *      - N - N(Many to Many)
 */