package Lesson_1.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("Hello", "World", "Test", "Swap", "Array");
        System.out.println(swapArrayItem(strList, 1,4)); // [Hello, Array, Test, Swap, World]

        List<Integer> intList = Arrays.asList(0, 1, 2, 3, 4, 5);
        System.out.println(swapArrayItem(intList, 2,0)); // [2, 1, 0, 3, 4, 5]

        Integer[] intArr = {0, 1, 2, 3, 4, 5};
        List<Integer> convertedIntList = convertArrayIntoList(intArr);
        convertedIntList.add(6);
        System.out.println(convertedIntList); // [0, 1, 2, 3, 4, 5, 6]

        String[] strArr = {"Again", "Test", "Method", "Convert", "Array"};
        List<String> convertedStrList = convertArrayIntoList(strArr);
        convertedStrList.add("To");
        convertedStrList.add("List");
        System.out.println(convertedStrList); // [Again, Test, Method, Convert, Array, To, List]

    }

    public static <T> List<T> swapArrayItem (List<T> list, int from, int to) {
        List<T> temp = new ArrayList<>();
        temp.addAll(0, list);
        Collections.swap(temp, from, to);

        return temp;
    }

    public static <T> List<T> convertArrayIntoList (T[] arr) {
        return Arrays.stream(arr).collect(Collectors.toList());
    }
}
