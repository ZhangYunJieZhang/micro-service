package com.zyj.jetcache.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zyj
 * 实体类，必须序列化
 */
@Data
public class Student implements Serializable {



    public Student(Integer id ,String name , Integer gender){
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    private Integer id;
    private String name;
    private Integer gender;
}
