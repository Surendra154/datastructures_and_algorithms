package com.reddy.algotoolbox.week5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChangeDP {
    /**
     * top down approach DP
     *
     * @param total
     * @param coins
     * @param map -> total to its minimum int count
     * @return
     */
    private static int getChange(int total, int[] coins, Map<Integer, Integer> map) {
        //write your code here
        if(total == 0){
            return 0;
        }

        if(map.containsKey(total)){
            return map.get(total);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if(coins[i] > total){
                continue;
            }

            int value = getChange(total - coins[i], coins, map);

            if(value < min){
                min = value;
            }

        }

        min = (min == Integer.MAX_VALUE ? min : min + 1);

        map.put(total, min);

        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] coins = {1, 3, 4};
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(getChange(m, coins, map));

    }
}

