package com.bootdo.postapi;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UpdateDto implements Serializable {
    private int versionCode;
    private String message;
    private int required;
    private String url;
    private String versionName;
    private int canDrop;//是否可以降级
}
