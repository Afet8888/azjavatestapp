package com.afet;

import com.afet.Entities.User;

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


//        List<String> string = new ArrayList<>();
//        string.add("One");
//        string.add("Twooo");
//        string.add("THree");
//        string.add("Fooooure");
//        string.add("Five");
//        string.add("in");
//        string.add("Oe");
//        System.out.println(Arrays.toString(string.toArray()));
//        System.out.println(longestString(string));

//        List<User> users = new ArrayList<>();
//        users.add(new User("user","abvgd@mail.ru","123456"));
//        users.add(new User("user","bbvgd@mail.ru","123456"));
//        users.add(new User("user","bcbvgd@mail.ru","123456"));
//        users.add(new User("personOne","abvgd@mail.ru","123456"));
//        users.add(new User("wersonTwo","abvgd@mail.ru","123456"));
//        users.add(new User("aaaaaaa","abvgd@mail.ru","123456"));
//        System.out.println(sortByUsernameThenByEmail(users));

        Integer[] ints = {1, 2, 65, 7, 3, 6, 2, 3, 4, 8, 17};
        System.out.println(Arrays.toString(ints));
        ints = primeNumbersFromArrayLambdas(ints);
        System.out.println(Arrays.toString(ints));





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

    private static List<User> sortByUsernameThenByEmail(List<User> listOfUsers) {
        return listOfUsers.parallelStream().
                sorted(Comparator.comparing(User::getUsername).
                        thenComparing(User::getEmail)).collect(Collectors.toList());
    }

    private static Integer[] primeNumbersFromArray(Integer[] array) {
        List<Integer> tempList = new ArrayList<>(Arrays.asList(array));
        tempList.removeIf(item -> !isPrime(item));
        return tempList.toArray(new Integer[tempList.size()]);
    }

    private static Integer[] primeNumbersFromArrayLambdas(Integer[] array) {
        List<Integer> tempList = new ArrayList<>(Arrays.asList(array));
        List<Integer> newList = tempList.parallelStream().
                filter(Main::isPrime).
                collect(Collectors.toList());
        return newList.
                toArray(new Integer[newList.size()]);
    }

    private static boolean isPrime(Integer num) {
        if(num<0)num*=-1;
        if(num == 1)return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }


}
