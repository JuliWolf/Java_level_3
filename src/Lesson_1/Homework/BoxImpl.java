package Lesson_1.Homework;

import java.util.ArrayList;
import java.util.List;

public class BoxImpl<T extends Fruit > implements Box<T> {
    private List<T> fruits = new ArrayList<>();

    @Override
    public List<T> getFruits() {
        return fruits;
    }

    @Override
    public int getTotalWeight() {
        return fruits
            .stream()
            .mapToInt(Fruit::getWeight)
            .sum();
    }

    @Override
    public void putFruit(T fruit) {
        fruits.add(fruit);
    }

    @Override
    public void pourFruits(Box<T> box) {
        fruits.addAll(box.getFruits());
        box.clearBox();
    }

    @Override
    public void clearBox() {
        fruits = new ArrayList<>();
    }

    @Override
    public boolean isEqual(Box<?> box) {
        return getTotalWeight() == box.getTotalWeight();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T fruit: fruits) {
            sb.append("Название: ");
            sb.append(fruit.getName());
            sb.append(", Вес: ");
            sb.append(fruit.getWeight());
            sb.append("\n");
        }

        return sb.toString();
    }
}
