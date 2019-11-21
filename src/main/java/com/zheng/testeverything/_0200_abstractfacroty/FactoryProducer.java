package com.zheng.testeverything._0200_abstractfacroty;

/**
 * @author zhengchentong on 2019/11/21
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if ("SHAPE".equalsIgnoreCase(choice)) {
            return new ShapeFactory();
        } else if ("COLOR".equalsIgnoreCase(choice)) {
            return new ColorFactory();
        }
        return null;
    }
}
