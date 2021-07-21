package com.example.model.repository;

import com.example.model.bean.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> findAll() {
//        return BaseRepository.entityManager.createQuery(
//                "select s from product s", Product.class).getResultList();
        String queryStr = "SELECT p FROM product AS p";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(queryStr, Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
//        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
//        transaction.begin();
//        BaseRepository.entityManager.persist(product);
//        transaction.commit();
        Transaction transaction = null;
        Session session = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.find(Product.class, id);
//       return BaseRepository.entityManager.createQuery(
//                "select s from product s where s.id= :id", Product.class).setParameter("id",id).getSingleResult();
    }

    @Override
    public List<Product> findByName(String name) {
        return BaseRepository.entityManager.createQuery(
                "select s from product s where s.name like concat('%',:name,'%')", Product.class)
                .setParameter("name", name).getResultList();
    }

    @Override
    public void update(int id, Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product productUpdate = findById(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setDescription(product.getDescription());
            productUpdate.setManufacturer(product.getManufacturer());
            session.saveOrUpdate(productUpdate);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(findById(id));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
