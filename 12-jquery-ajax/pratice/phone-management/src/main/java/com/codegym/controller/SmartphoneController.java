package com.codegym.controller;

import com.codegym.model.entity.Smartphone;
import com.codegym.model.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }
    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSmartphone(@PathVariable Long id,@RequestBody Smartphone smartphone) {
        Smartphone smartphoneCurrent = smartphoneService.findById(id).orElse(null);
        if(smartphoneCurrent==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneCurrent.setModel(smartphone.getModel());
        smartphoneCurrent.setPrice(smartphone.getPrice());
        smartphoneCurrent.setProducer(smartphone.getProducer());
        smartphoneService.save(smartphoneCurrent);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}