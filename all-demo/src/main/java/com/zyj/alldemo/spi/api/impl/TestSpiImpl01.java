package com.zyj.alldemo.spi.api.impl;

import com.zyj.alldemo.spi.api.TestSpi;

public class TestSpiImpl01 implements TestSpi {
    @Override
    public String sayHello() {
        return "这是一号实现类";
    }
}
