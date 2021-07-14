package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public int convert(int usd, int rate) {
        return usd*rate;
    }
}
