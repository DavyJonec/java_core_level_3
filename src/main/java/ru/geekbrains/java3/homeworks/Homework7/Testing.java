package ru.geekbrains.java3.homeworks.Homework7;

public class Testing {
    public static  void method1() {
        System.out.println("met1");
    }

    @BeforeSuite
    public static void start() {
        System.out.println("Начало");
    }

    @Test(priority = 4)
    public static  void method2() {
        System.out.println("Что я пропустил");
    }

    @Test(priority = 8)
    public static  void method3() {
        System.out.println("Don't understand");
    }

    @Test(priority = 9)
    public static  void method4() {
        System.out.println("Бонжур");
    }

    @AfterSuite
    public static void shutdown() {
        System.out.println("Конец");
    }

    @Test(priority = 10)
    public static  void method5() {
        System.out.println("Привет, как дела");
    }


}