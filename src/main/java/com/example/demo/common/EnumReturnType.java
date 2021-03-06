package com.example.demo.common;

public enum EnumReturnType {

    DEFAULT("Default JSON"),
    GRID("Grid JSON");

    private final String value;

    EnumReturnType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
