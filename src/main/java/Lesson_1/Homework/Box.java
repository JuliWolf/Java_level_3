package Lesson_1.Homework;

import java.util.List;

public interface Box<T extends Fruit> {
    List<T> getFruits();

    int getTotalWeight();

    void putFruit(T fruit);

    void pourFruits(Box<T> box);

    void clearBox();

    boolean isEqual(Box<?> box);
}
