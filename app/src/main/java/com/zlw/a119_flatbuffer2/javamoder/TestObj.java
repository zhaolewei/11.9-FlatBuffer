package com.zlw.a119_flatbuffer2.javamoder;

import java.util.List;

/**
 * Created by zlw on 2016/11/9 0009.
 */
public class TestObj {

    private int code;
    private List<StudentBean> list;

    public TestObj() {
    }

    public TestObj(int code, List<StudentBean> list) {
        this.code = code;
        this.list = list;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<StudentBean> getList() {
        return list;
    }

    public void setList(List<StudentBean> list) {
        this.list = list;
    }
}
