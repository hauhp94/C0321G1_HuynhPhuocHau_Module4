package com.example.model.service;

import com.example.model.entity.ContractDetail;
import com.example.model.entity.Customer;

import java.util.List;

public interface ContractDetailService {
    void save(ContractDetail contractDetail);
    List<ContractDetail> findAll();
}
