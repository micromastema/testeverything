package com.zheng.testeverything._0100_factory;

/**
 * @author zhengchentong on 2019/11/21
 */
class FactoryPatternDemo {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("CIRCLE");
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        Shape square = shapeFactory.getShape("SQUARE");
        circle.draw();
        rectangle.draw();
        square.draw();
    }
}
