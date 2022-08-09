package com.zyj.alldemo.lambda.run;

import com.zyj.alldemo.lambda.service.PayService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author zyj
 * 测试lambda表达式
 */
public class TestLambda {

    public static void main(String[] args){
        /**
         * 只有一个参数可以不写()
         * 方法体只有一句话可以不写{}
         * 只有一个return语句的话return关键字可以省略
         *
         */
        PayService payService = (money)->{System.out.println("支付了" + money + "元");return "success";};
        payService.pay(10);
        payService.hello();

        List<String> stringList = new ArrayList<String>();
        stringList.add("zhangsan");
        stringList.add("lisi");
        stringList.add("wangwu");
        stringList.sort((s1,s2)-> s1.charAt(0)-s2.charAt(0));
        stringList.forEach(s->System.out.println(s));

        stringList.stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return false;
                    }
                })
                .sorted((s1,s2)-> s1.charAt(0)-s2.charAt(0))
                .limit(2)
                .forEach(s->System.out.println(s));
    }
}
