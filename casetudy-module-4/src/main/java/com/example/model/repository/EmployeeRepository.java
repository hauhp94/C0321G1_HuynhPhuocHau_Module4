package com.example.model.repository;

import com.example.model.entity.Customer;
import com.example.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value="select * from employee where concat(employee_name,employee_phone) like concat('%',:keyword,'%')",nativeQuery=true)
    Page<Employee> searchByNameOrPhone(String keyword,Pageable pageable);
    Page<Employee> findAllByIsDelete(int isDelete, Pageable pageable);
    List<Employee> findAllByIsDelete(int isDetele);

}
