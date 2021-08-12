package com.example.model.repository;

import com.example.model.entity.Contract;
import com.example.model.entity.Customer;
import com.sun.org.apache.xpath.internal.objects.XBoolean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value="select * from customer where is_delete=0 and concat(customer_name,customer_phone) like %:keyword%",nativeQuery=true)
    Page<Customer> searchByNameOrPhone(String keyword,Pageable pageable);

    Page<Customer> findAllByIsDelete(int isDelete,Pageable pageable);
    List<Customer> findAllByIsDelete(int isDetele);
    Page<Customer> findAllByIsDeleteAndServiceIdGreaterThan(int isDelete,int number,Pageable pageable);
    boolean existsByCustomerCode(String code);
    Customer findByCustomerCode(String code);



}
