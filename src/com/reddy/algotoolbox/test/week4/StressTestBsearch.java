package com.reddy.algotoolbox.test.week4;

import com.reddy.algotoolbox.week4.BinarySearch;

import java.util.*;
import java.util.stream.Collectors;

public class StressTestBsearch {

    public static void main(String[] args) {
        Random r = new Random();
        int n = 1000000000;
        int k = 10000;


        BinarySearch bSearch = new BinarySearch();

        boolean flag = true;
        while(flag) {

            int rand = r.nextInt(n);
            int[] arr = new int[rand];
            for (int i=0; i<rand; i++){
                arr[i] = r.nextInt(n);
            }

            int srand = r.nextInt(k);

            for (int j=0;j<srand;j++){
                int tosearch = r.nextInt(n);
                Set<Integer> mySet = Arrays.stream(arr).boxed().collect(Collectors.toSet());
                int[] myArray = mySet.stream().mapToInt(Integer::intValue).toArray();
                Arrays.sort(myArray);
                int lsearchIndex = BinarySearch.linearSearch(myArray, tosearch);

                int bSearchIndex = BinarySearch.binarySearchIter(myArray, 0, arr.length-1, tosearch);
                if(lsearchIndex == bSearchIndex){
                    continue;
                }else{
                    flag = false;
                    System.out.println("failed while searching key:"+ tosearch);
                   // int index = BinarySearch.linearSearch(arr, tosearch);
                    System.out.println("linearSearch -> " + lsearchIndex) ;
                    System.out.println("Bsearch -> " + bSearchIndex);
                    System.out.println("array[keylinear] ->" + myArray[lsearchIndex]);
                    System.out.println("array[keyBinary] ->" + myArray[bSearchIndex]);

                    break;
                }
            }

        }
    }

}
