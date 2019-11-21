package com.zheng.testeverything._0200_abstractfacroty;

/**
 * @author zhengchentong on 2019/11/21
 */
public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        Shape circle = shapeFactory.getShape("CIRCLE");
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        Shape square = shapeFactory.getShape("SQUARE");
        circle.draw();
        rectangle.draw();
        square.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color red = colorFactory.getColor("RED");
        Color green = colorFactory.getColor("Green");
        Color blue = colorFactory.getColor("BLUE");
        red.fill();
        green.fill();
        blue.fill();
    }
}
