package com.examples;

public class SelectionSort {

    private int[] sort(int[] input){
        int min;
        for(int i = 0; i < input.length; i ++){
            for( int j = i+1; j< input.length; j++){
                min = input[i];
                if(input[j] < min){
                   int temp  = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
        return input;
    }
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] unsorted = {64,25,12,22,11,7,73};
        int[] sorted = selectionSort.sort(unsorted);
        for(int i = 0; i<sorted.length;i++){
            System.out.println(sorted[i]);
        }
    }

}
