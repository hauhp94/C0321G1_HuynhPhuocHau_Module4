package com.example.model.repository;

import com.example.model.entity.Contract;
import com.example.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAllByIsDelete(int isDelete, Pageable pageable);
    List<Contract> findAllByIsDelete(int isDetele);


}
