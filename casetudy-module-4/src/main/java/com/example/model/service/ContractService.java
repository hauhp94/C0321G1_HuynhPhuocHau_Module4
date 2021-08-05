package com.example.model.service;

import com.example.model.entity.Contract;

import java.util.List;

public interface ContractService {
    void save(Contract contract);
    List<Contract> findAll();
}
