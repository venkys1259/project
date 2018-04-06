package com.examples;

import java.util.Scanner;

public class Palindrome {
    private boolean isPalindrome(String s){
        int begin = 0;
        int end = s.length()-1;
        int mid = (begin + end)/2;
        for(int i = begin; i<mid;i++){
            if(s.charAt(i) != s.charAt(end))
                return false;
            else
                end--;
                begin++;

        }
        if(end == begin){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Palindrome palindrome = new Palindrome();
        boolean isPalindrome = palindrome.isPalindrome(input);
        System.out.println(input + " Is Palindrome --  " + isPalindrome);
    }
}
