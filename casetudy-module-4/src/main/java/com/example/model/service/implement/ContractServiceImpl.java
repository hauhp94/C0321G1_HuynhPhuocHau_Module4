package com.example.model.service.implement;

import com.example.model.entity.AttachService;
import com.example.model.entity.Contract;
import com.example.model.entity.ContractDetail;
import com.example.model.repository.ContractRepository;
import com.example.model.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;
    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAllByIsDelete(0);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findByContractEndDay(String s, Pageable pageable) {
        return contractRepository.findAllByContractEndDateContaining(s, pageable);
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id).get();
    }

//    @Override
//    public Double getTotalMoney(Contract contract) {
//        double serviceCost = contract.getService().getServiceCost();
////        double attachServiceCost = 0;
////        for (ContractDetail contractDetail : contract.getContractDetails()) {
////            attachServiceCost += contractDetail.getQuantity() * contractDetail.getAttachService().getCost();
////        }
//        return serviceCost;
//    }
}
