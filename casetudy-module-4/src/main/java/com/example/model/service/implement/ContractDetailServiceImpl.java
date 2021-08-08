package com.example.model.service.implement;

import com.example.model.entity.ContractDetail;
import com.example.model.repository.ContractDetailRepository;
import com.example.model.service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    ContractDetailRepository contractDetailRepository;
    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }
}
