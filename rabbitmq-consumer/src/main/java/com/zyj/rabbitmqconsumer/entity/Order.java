package com.zyj.rabbitmqconsumer.entity;

import java.io.Serializable;

/**
 * @author zyj
 * 测试消费者直接用实体类接收，必须序列化
 */
public class Order implements Serializable {

    private String id;
    private String name;

    public Order() {
    }
    public Order(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
