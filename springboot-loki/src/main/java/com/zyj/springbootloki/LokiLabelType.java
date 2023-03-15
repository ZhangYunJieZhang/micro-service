package com.zyj.springbootloki;

/**
 * loki日志标签枚举，可以把标签换成请求方法描述或者方法名之类
 */
public enum LokiLabelType {

    DEFAULT("默认标签"),
    A("getuser"),
    B("getconsultlist"),
    C("C标签");

    private String desc;

    LokiLabelType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

}
