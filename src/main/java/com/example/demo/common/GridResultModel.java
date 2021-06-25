package com.example.demo.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GridResultModel {

    private boolean result;

    private Object data;

    public GridResultModel(Object data, boolean result) {
        this.data = (ContentsModel) data;
        this.result = result;
    }
}
