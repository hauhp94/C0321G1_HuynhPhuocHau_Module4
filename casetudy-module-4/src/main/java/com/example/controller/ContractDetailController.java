package com.example.controller;

import com.example.dto.ContractDetailDto;
import com.example.dto.ContractDto;
import com.example.model.entity.AttachService;
import com.example.model.entity.Contract;
import com.example.model.entity.ContractDetail;
import com.example.model.service.AttachServiceService;
import com.example.model.service.ContractDetailService;
import com.example.model.service.ContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contract-detail")
public class ContractDetailController {
    @Autowired
    ContractService contractService;
    @Autowired
    AttachServiceService attachServiceService;
    @Autowired
    ContractDetailService contractDetailService;

    @GetMapping("/create")
    public String createContractDetail(Model model) {
        this.getSecondaryList(model);
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        return "/furama/contract_detail/create";
    }

    private void getSecondaryList(Model model) {
        List<Contract> contractList = contractService.findAll();
        List<AttachService> attachServiceList = attachServiceService.findAll();
        model.addAttribute("contractList",contractList);
        model.addAttribute("attachServiceList",attachServiceList);
    }

    @PostMapping("/create")
    public String saveContractDetail(@Valid @ModelAttribute ContractDetailDto contractDetailDto,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new ContractDetailDto().validate(contractDetailDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            getSecondaryList(model);
            return "/furama/contract_detail/create";
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            contractDetailService.save(contractDetail);
            redirectAttributes.addFlashAttribute("message", "create success contract detail id: " + contractDetail.getId());
            return "redirect:/contract-detail/create";
        }
    }

}
