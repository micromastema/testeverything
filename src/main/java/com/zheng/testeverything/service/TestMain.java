package com.zheng.testeverything.service;

/**
 * @author zhengct
 * @date 2020/1/8
 */
public class TestMain
{
    public static void main(String[] args)
    {
//编写一个程序，启动三个线程，三个线程的ID分别是A，B，C；，每个线程将自己的ID值在屏幕上打印5遍，打印顺序是ABCABC...
        MyService service = new MyService();
//        MyService2 service = new MyService2();

        Thread A = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 5; i++)
                {
                    service.printA();
                }
            }
        });
        A.setName("A");
        Thread B = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 5; i++)
                {
                    service.printB();
                }
            }
        });
        B.setName("B");
        Thread C = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 5; i++)
                {
                    service.printC();
                }
            }
        });
        C.setName("C");

        A.start();
        B.start();
        C.start();
    }
}