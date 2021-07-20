package codegym.model.repository.impl;

import codegym.model.bean.Customer;
import codegym.model.repository.ICustomerRepository;
import com.mysql.cj.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    @Override
    public List<Customer> findAll() {
        String queryStr = "SELECT c FROM customer AS c";
        TypedQuery<Customer> query = BaseRepository.entityManager.createQuery(queryStr, Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(int id) {
        String queryStr = "SELECT c FROM customer AS c WHERE c.id = :id";
        TypedQuery<Customer> query = BaseRepository.entityManager.createQuery(queryStr, Customer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Customer customer) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(customer);
        transaction.commit();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id) {

    }
}