package com.abdelqodous.kw.sorting.bubble;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Random().nextInt(1000000);
        }

        System.out.println("Array before sorting...");
        Arrays.stream(numbers)
                .forEach(System.out::println);

        bubbleSort(numbers);

        System.out.println("Array after sorting...");
        Arrays.stream(numbers)
                .forEach(System.out::println);
    }

    private static void bubbleSort(int[] numbers) {
        int temp;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < numbers.length -1; i++) {
                if (numbers[i] > numbers[i+1]){
                    temp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = temp;
                    swapped = true;
                }
            }
        }
    }
}
