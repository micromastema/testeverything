package com.zheng.testeverything._0100_factory;

/**
 * @author zhengchentong on 2019/11/21
 */
class ShapeFactory {
    //使用 getShape 方法获取形状类型的对象
    Shape getShape(String shapeType) {

        if (shapeType == null) {
            return null;
        }
        if ("CIRCLE".equalsIgnoreCase(shapeType)) {
            return new Circle();
        } else if ("RECTANGLE".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        } else if ("SQUARE".equalsIgnoreCase(shapeType)) {
            return new Square();
        }
        return null;
    }
}
