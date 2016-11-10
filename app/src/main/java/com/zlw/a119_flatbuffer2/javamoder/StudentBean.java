package com.zlw.a119_flatbuffer2.javamoder;

/**
 * Created by zlw on 2016/11/9 0009.
 */
public class StudentBean {
    private int id;
    private String name;

    public StudentBean() {
    }

    public StudentBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

