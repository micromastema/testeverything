package com.zheng.testeverything._0200_abstractfacroty;

/**
 * @author zhengchentong on 2019/11/21
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if("RED".equalsIgnoreCase(color)){
            return new Red();
        } else if("GREEN".equalsIgnoreCase(color)){
            return new Green();
        } else if("BLUE".equalsIgnoreCase(color)){
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shage) {
        return null;
    }
}
