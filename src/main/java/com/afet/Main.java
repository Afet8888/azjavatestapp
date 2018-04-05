package com.afet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 65, 7, 3, 6, 2, 3, 4, 8, 17};
        System.out.println(Arrays.toString(ints));
        ints = evenNumbersFromArray(ints);
        System.out.println(Arrays.toString(ints));
    }

    static Integer[] evenNumbersFromArray(Integer[] array) {
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                tempList.add(array[i]);
            }
        }
        return  tempList.toArray(new Integer[tempList.size()]);

    }
}
