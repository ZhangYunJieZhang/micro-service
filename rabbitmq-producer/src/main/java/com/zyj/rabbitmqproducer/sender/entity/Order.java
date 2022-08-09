package com.zyj.rabbitmqproducer.sender.entity;

import java.io.Serializable;

/**
 * @author zyj
 * 测试生产者直接用实体类发送，必须序列化，也必须跟消费者是同一个实体，这里直接新建同一个字段的实体，没有抽离成单独的jar，没测试行不行
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
