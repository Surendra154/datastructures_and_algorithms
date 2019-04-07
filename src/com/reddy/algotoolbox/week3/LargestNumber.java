package com.reddy.algotoolbox.week3;

import java.util.*;

public class LargestNumber {
    private static String largestNumber(ArrayList<String> a) {
        //write your code here
        String result = "";

        while(a.size() > 0){
            String maxDigit = "0";
            int index = 0;
            for(int i=0; i < a.size(); i++){
                if(isGreaterThanOrEqual(a.get(i), maxDigit)){
                    maxDigit = a.get(i);
                    index = i;

                }
            }
            result += a.remove(index);

        }
        return result;
    }

    private static boolean isGreaterThanOrEqual(String d, String maxDigit) {
        if(Integer.parseInt(d+maxDigit) >= Integer.parseInt(maxDigit+d))
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.next());
        }
        System.out.println(largestNumber(a));
    }
}

