package com.examples;

public class BubbleSort {

    private int[] sort(int[] input){
        for(int i = 0; i<input.length;i++){
            for(int j = 0; j<input.length-1;j++){
                if(input[j] > input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
        return input;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = {6,64,25,76,12,22,11,89,2};
        int[] sorted = bubbleSort.sort(input);
        for(int i = 0; i< sorted.length;i++){
            System.out.println(sorted[i]);
        }
    }

}
