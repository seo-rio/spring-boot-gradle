package com.example.demo.common;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ContentsModel {

    private Object contents;

    public ContentsModel(Object contents) {
        this.contents = contents;
    }
}
