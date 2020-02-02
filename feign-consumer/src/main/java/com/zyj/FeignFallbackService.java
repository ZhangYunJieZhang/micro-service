package com.zyj;

import org.springframework.stereotype.Service;

@Service
public class FeignFallbackService implements FeignInterface{
    @Override
    public String toHello() {
        return "远程调用失败";
    }
}
