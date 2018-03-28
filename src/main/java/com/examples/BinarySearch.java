package com.examples;

public class BinarySearch {

    private static  boolean search(int[] input,int target){
        int left = 0,right = input.length-1;
        while(left <= right){
            int middle = (left + right)/2;
            if(input[middle] == target){
                return true;
            }
            else if(target < input[middle]){
                right = middle-1;
            }
            else{
                left = middle+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {8,9,10,12,15,16,23};
        boolean isElementFound = search(input, 10);
        System.out.println(isElementFound);

    }
}
