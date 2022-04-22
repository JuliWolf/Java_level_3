package Lesson_1.Homework;

public class BoxApp {
    public static void main(String[] args) {
        BoxImpl<Apple> appleBox = new BoxImpl<>();
        appleBox.putFruit(new Apple("Green Apple", 2));
        appleBox.putFruit(new Apple("Red Apple", 3));
        appleBox.putFruit(new Apple("Yellow Apple", 1));
        appleBox.putFruit(new Apple("Exotic Apple", 4));
        System.out.println(appleBox.getTotalWeight()); // 10
        System.out.println(appleBox);

        BoxImpl<Apple> appleBox2 = new BoxImpl<>();
        appleBox2.putFruit(new Apple("Pink Lady", 2));
        appleBox2.putFruit(new Apple("Gala", 1));
        System.out.println(appleBox2);

        appleBox.pourFruits(appleBox2);

        System.out.println(appleBox);
        System.out.println(appleBox2);

        BoxImpl<Orange> orangeBox = new BoxImpl<>();
        orangeBox.putFruit(new Orange("Hamlin Orange", 3));
        orangeBox.putFruit(new Orange("Verna Orange", 4));
        orangeBox.putFruit(new Orange("Salustiana Orange", 6));
        System.out.println(orangeBox.getTotalWeight()); // 13

        System.out.println(orangeBox.isEqual(appleBox));
        System.out.println(orangeBox.isEqual(appleBox2));

    }
}
