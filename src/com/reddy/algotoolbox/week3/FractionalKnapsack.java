package com.reddy.algotoolbox.week3;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        double minval = 0;
        //write your code here
        int n = values.length;
        double [] fracValues = new double[n];

        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        for (int i=0; i<n; i++){

            fracValues[i] = ((double)values[i]) / (double)weights[i];
        }
        Arrays.sort(fracValues);

       //System.out.println(fracValues.toString());
        int length = n - 1;

        for(int i=values.length-1; i >=0; i--){
            if(capacity == 0)
                return value;

            minval = Math.min(weights[i], capacity);
            value += minval * fracValues[i];
            weights[i] -= minval;
            capacity -= minval;


//            if (weights[length] > 0 ){
//                minval = Math.min(weights[length], capacity);
//                value += minval * fracValues[length];
//                weights[length] -= minval;
//                capacity -= minval;
//            }
//
//            if (weights[length] == 0)
//                length--;

        }

        return Double.parseDouble(df.format(value));
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
