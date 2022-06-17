package com.cas.bean;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * resources
 * @author 
 */
public class RoleResource implements Serializable {

    @TableId
    private Integer id;

    private String pattern;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}