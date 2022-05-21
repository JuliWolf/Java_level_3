package Lesson_6.Homework;

import java.util.Arrays;

public class ArrayGenerator {

    public int[] getArrayAfter4 (int[] arr) throws RuntimeException{
        if (arr.length == 0) { throw new NullPointerException(); }

        int indexOf4 = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 4) continue;

            indexOf4 = i;
        }

        if (indexOf4 == -1) {
            throw new RuntimeException();
        }else {
            return Arrays.copyOfRange(arr, indexOf4 + 1, arr.length);
        }
    }

    public boolean checkArrayFor1And4 (int[] arr) {
        int count1 = 0;
        int count4 = 0;

        for (int x : arr) {
            if (x == 1) {
                count1++;
                continue;
            }

            if (x == 4) {
                count4++;
                continue;
            }

            return false;
        }

        return (count1 > 0 && count4 > 0);
    }
}
