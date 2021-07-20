package com.example.model.repository;

import com.example.model.bean.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

//import javax.persistence.EntityTransaction;
import javax.persistence.EntityTransaction;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository{
    @Override
    public List<Product> findAll() {
        return BaseRepository.entityManager.createQuery(
                "select s from product s", Product.class).getResultList();
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
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {

    }
}
