package Lesson_1.Homework;

public abstract class Fruit {
    private final String name;
    private final Integer weight;

    protected Fruit(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
