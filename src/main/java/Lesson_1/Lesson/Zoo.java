package Lesson_1.Lesson;

import java.util.ArrayList;
import java.util.List;

class Zoo<T> {
    private List<T> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public boolean encage(T animal) {
        return animals.add(animal);
    }

    public T release(T animal) {
        if (animals.contains(animal)) {
            animals.remove(animal);
            return animal;
        }
        return null;
    }

    // не работает для статических методов
    //    public static T release(T animal) {} // error!

    // но можно делать так
    public static <A> Zoo<A> create() {
        return new Zoo<A>();
    }

    public static <A> boolean encage(Zoo<A> zoo, A animal) {
        return zoo.encage(animal);
    }
}
