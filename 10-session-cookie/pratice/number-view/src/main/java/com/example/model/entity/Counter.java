package com.example.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Counter {
    private int count;


    public Counter(int count) {
        this.count = count;
    }

    public int increment() {
        return count++;
    }
}
