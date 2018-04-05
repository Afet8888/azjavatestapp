package com.afet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        Integer[] ints = {1, 2, 65, 7, 3, 6, 2, 3, 4, 8, 17};
//        System.out.println(Arrays.toString(ints));
//        ints = evenNumbersFromArray(ints);
//        System.out.println(Arrays.toString(ints));


        List<String> string = new ArrayList<>();
        string.add("One");
        string.add("Twooo");
        string.add("THree");
        string.add("Fooooure");
        string.add("Five");
        string.add("in");
        string.add("Oe");
        System.out.println(Arrays.toString(string.toArray()));
        System.out.println(longestString(string));
    }

    static Integer[] evenNumbersFromArray(Integer[] array) {
        //        for (int i = 0; i < array.length; i++) {
//            if (array[i] % 2 == 0) {
//                tempList.add(array[i]);
//            }
//        }
        List<Integer> tempList = new ArrayList<>(Arrays.asList(array));
        tempList.removeIf(item -> item % 2 == 1);
        //tempList = tempList.parallelStream().filter(item -> item%2==0).collect(Collectors.toList());
        return tempList.toArray(new Integer[tempList.size()]);
    }


    private static String longestString(List<String> strings) {
//        strings.sort(Comparator.comparing(String::length));
//        return strings.get(strings.size()-1);
        return strings.parallelStream().max(Comparator.comparing(String::length)).get();
//        return strings.parallelStream().max(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if (o1.length() <= o2.length()) return -1;
//                else return 1;
//            }
//        }).get();
    }

}
