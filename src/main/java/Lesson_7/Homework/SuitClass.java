package Lesson_7.Homework;

public class SuitClass {

    @BeforeSuite
    public void start() {
        System.out.println("start");
    }

    @AfterSuite
    public void stop() {
        System.out.println("stop");
    }

//    @AfterSuite
//    public void stop1() {
//        System.out.println("stop1");
//    }

    @Test(priority = 9)
    public void test1() {
        System.out.println("priority 9");
    }

    @Test(priority = 9)
    public void test2() {
        System.out.println("priority 9");
    }

    @Test(priority = 1)
    public void test3() {
        System.out.println("priority 1");
    }

    @Test(priority = 6)
    public void test4() {
        System.out.println("priority 6");
    }

    @Test(priority = 122)
    public void test6() {
        System.out.println("priority 122");
    }

    @Test(priority = -5)
    public void test7() {
        System.out.println("priority -5");
    }

    @Test
    public void test8() {
        System.out.println("priority default");
    }

    public void method() {
        System.out.println("method");
    }



}
