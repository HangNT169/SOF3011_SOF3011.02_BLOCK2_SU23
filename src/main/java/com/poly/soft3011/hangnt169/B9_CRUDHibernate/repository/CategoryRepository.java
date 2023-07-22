package com.poly.soft3011.hangnt169.B9_CRUDHibernate.repository;

import com.poly.soft3011.hangnt169.B9_CRUDHibernate.entity.Category;
import com.poly.soft3011.hangnt169.B9_CRUDHibernate.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hangnt
 */
public class CategoryRepository {

    // get all => SELECT => READ
    public List<Category> getAll() {
        List<Category> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Category ", Category.class);
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    public Category getOne(Long id10) {
        Category category = null;
        // Code
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM Category WHERE id1111 =:id1 ", Category.class);
            q.setParameter("id1", id10); // set gia tri cho tham so
            category = (Category) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }

    // Add => Insert into => CREATE
    public Boolean add(Category category) {
        Transaction transaction = null;
        // Code
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Add => save, saveOrUpdate, persist
            session.persist(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update => UPDATE => UPDATE
    public Boolean update(Category category) {
        Transaction transaction = null;
        // Code
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Update => saveOrUpdate, merge
            session.merge(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // delete => DELETE => DELETE
    public Boolean delete(Category category) {
        Transaction transaction = null;
        // Code
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Delete => delete
            session.delete(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        List<Category> lists = new CategoryRepository().getAll();
        for (Category c : lists) {
            System.out.println(c.toString());
        }
    }
}
