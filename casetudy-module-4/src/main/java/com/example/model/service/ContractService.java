package com.example.model.service;

import com.example.model.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    void save(Contract contract);
    List<Contract> findAll();
    Page<Contract> findAll(Pageable pageable);

    Page<Contract> findByContractEndDay(String s, Pageable pageable);
    Contract findById(int id);
}
