package com.reddy.algotoolbox.week3;

import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        HashMap<Integer, Integer> numMap = new HashMap<>();

        //write your code here
        int left =1;
        int right = n;
        int sum = 0;

        while (sum != n){

            if(right == 0)
                break;

           // if(numMap.containsKey(left)){


             if(numMap.containsKey(right)){ //} else
                int lastadded = summands.remove(summands.size() - 1);
                numMap.remove(right);
                sum -= lastadded;
                right += lastadded;

            }
            else{
                numMap.put(left, 0);
                summands.add(left);
                sum += left;
                right -= left;
                left++;
            }

       //     System.out.println(numMap.toString() + "right:" + right);
        }


        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

