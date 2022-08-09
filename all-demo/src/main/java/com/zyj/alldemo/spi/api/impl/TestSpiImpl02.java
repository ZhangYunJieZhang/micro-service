package com.zyj.alldemo.spi.api.impl;

import com.zyj.alldemo.spi.api.TestSpi;

public class TestSpiImpl02 implements TestSpi {
    @Override
    public String sayHello() {
        return "这是二号实现类";
    }
}
