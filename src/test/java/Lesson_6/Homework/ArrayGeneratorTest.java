package Lesson_6.Homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayGeneratorTest {
    private ArrayGenerator generator = new ArrayGenerator();

    // getArrayAfter4
    @Test
    public void testEmptyArray () {
        int[] arr = new int[0];
        Assertions.assertThrows(NullPointerException.class, () -> generator.getArrayAfter4(arr));
    }

    @Test void testArrayWithout4 () {
        int[] arr = {1,5,8,6,3,6,8,2,3};
        Assertions.assertThrows(RuntimeException.class, () -> generator.getArrayAfter4(arr));
    }

    @Test void testArrayWith4 () {
        int[] arr = { 2, 4, 4, 2, 3, 4, 1, 7};
        int[] expectedResult = { 1, 7 };
        Assertions.assertArrayEquals(expectedResult, generator.getArrayAfter4(arr));
    }

    @Test void testArrayWithOnly4 () {
        int[] arr = { 4,4,4,4,4,4 };
        int[] expectedResult = {};
        Assertions.assertArrayEquals(expectedResult, generator.getArrayAfter4(arr));
    }

    // checkArrayFor1And4
    @Test void testArrayWithout1And4 () {
        int[] arr = { 2,6,8,0 };
        Assertions.assertEquals(false, generator.checkArrayFor1And4(arr));
    }

    @Test void testArrayWith1AndWithout4 () {
        int[] arr = { 1, 2, 6, 8, 0 };
        Assertions.assertEquals(false, generator.checkArrayFor1And4(arr));
    }

    @Test void testArrayWith4AndWithout1 () {
        int[] arr = { 4,4,4,4,4 };
        Assertions.assertEquals(false, generator.checkArrayFor1And4(arr));
    }

    @Test void testArrayWithDifferentNumbers () {
        int[] arr = { 2, 6, 8, 0, 4, 5, 3, 1, 3, 1 };
        Assertions.assertEquals(false, generator.checkArrayFor1And4(arr));
    }

    @Test void testArrayWith4And1 () {
        int[] arr = { 1,4,4,1, };
        Assertions.assertEquals(true, generator.checkArrayFor1And4(arr));
    }

}
