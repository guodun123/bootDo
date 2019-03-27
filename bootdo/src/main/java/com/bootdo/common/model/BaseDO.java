package com.bootdo.common.model;

import java.io.Serializable;

public class BaseDO implements Serializable {
    private static final long serialVersionUID = -4251888792380185236L;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
