package com.reddy.algotoolbox.week3;

import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        int value10 = 10;
        int value5 = 5;
        int value1 = 1;
        int changeCount=0;

        while(m > 0){
            if(m >= value10){
                m = m - value10;
                changeCount++;
            }else if (m >= value5){
                m = m - value5;
                changeCount++;
            }else if(m >= value1){
                m = m - value1;
                changeCount++;
            }
        }

        return changeCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }


}

