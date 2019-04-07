package com.reddy.algotoolbox.week4;

import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int left, int right) {
        long numberOfInversions = 0;
        /*if (right <= left) {
            return numberOfInversions;
        }*/
        if(left < right){
            int mid = left + (right-left) / 2;
            numberOfInversions += getNumberOfInversions(a, left, mid);
            numberOfInversions += getNumberOfInversions(a, mid+1, right);
            //write your code here
            numberOfInversions += mergeAndCount(a, left, mid, right);
        }

        return numberOfInversions;
    }

    private static long mergeAndCount(int[] a, int left, int mid, int right){

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int invCount = 0;
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = a[left + i];
        for (int j=0; j<n2; ++j)
            R[j] = a[mid + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = left;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                a[k] = L[i];
                i++;
            }
            else
            {
                /**
                 * Key idea:
                 * refer: https://www.youtube.com/watch?v=Vj5IOD7A6f8
                 *
                 * so in merge logic of merge sort, if in left sort array given item is
                 * larger than the right one, remaining to the right of left sorted array are also greater
                 */
                invCount += (n1 - i);
                a[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            a[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            a[k] = R[j];
            j++;
            k++;
        }
        return invCount;


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
       // int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, 0, a.length-1));
    }
}

