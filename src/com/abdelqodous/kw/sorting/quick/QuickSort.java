package com.abdelqodous.kw.sorting.quick;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }
        System.out.println("--------- Array of random numbers before sorting --------");
        printArray(numbers);

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("\n--------- Array of random numbers after sorting --------");
        printArray(numbers);
    }

    private static void quickSort(int[] numbers, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex)
            return;

        int pivIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = numbers[pivIndex];
        getSwap(numbers, pivIndex, highIndex);

        int lPointer = partition(numbers, lowIndex, highIndex, pivot);

        quickSort(numbers, lowIndex, lPointer-1);
        quickSort(numbers, lPointer+1, highIndex);
    }

    private static int partition(int[] numbers, int lowIndex, int highIndex, int pivot) {
        int lPointer = lowIndex;
        int rPointer = highIndex;

        while (lPointer < rPointer){

            while (numbers[lPointer] <= pivot && lPointer < rPointer){
                lPointer++;
            }

            while (numbers[rPointer] >= pivot && lPointer < rPointer){
                rPointer--;
            }

            getSwap(numbers,lPointer, rPointer);
        }

        getSwap(numbers, lPointer, highIndex);
        return lPointer;
    }

    private static void getSwap(int[] numbers,int lPointer, int rPointer) {
        int temp = numbers[lPointer];
        numbers[lPointer] = numbers[rPointer];
        numbers[rPointer] = temp;
    }

    private static void printArray(int[] numbers) {
        for (int number : numbers){
            System.out.print(number +"  ");
        }
    }
}
