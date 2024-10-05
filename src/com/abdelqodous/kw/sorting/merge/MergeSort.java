package com.abdelqodous.kw.sorting.merge;

import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Random().nextInt(1000000);
        }

        System.out.println("------------- Array before sorting -------------");
//        printArray(numbers);

        mergeSort(numbers);

        System.out.println("\n------------- Array after sorting -------------");
//        printArray(numbers);
    }

    private static void mergeSort(int[] numbers) {
        if (numbers.length < 2)
            return;

        int mid = numbers.length / 2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[numbers.length - mid];

        for (int i = 0; i < mid; i++) {
            leftHalf[i] = numbers[i];
        }
        for (int i = mid; i < numbers.length; i++) {
            rightHalf[i - mid] = numbers[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(numbers, leftHalf, rightHalf);
    }

    private static void merge(int[] numbers, int[] leftHalf, int[] rightHalf){
        int i = 0, j = 0, k = 0;
        while ( i < leftHalf.length && j < rightHalf.length){
            if(leftHalf[i] <= rightHalf[j]){
                numbers[k] = leftHalf[i];
                i++;
            } else{
                numbers[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftHalf.length){
            numbers[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightHalf.length){
            numbers[k] = rightHalf[j];
            j++;
            k++;
        }
    }


    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "  ");
        }
    }
}
