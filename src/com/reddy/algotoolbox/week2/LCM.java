package com.reddy.algotoolbox.week2;

import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static long lcm(int a, int b){
    long gcd = gcd_euclid(a, b);
    long product  = (long)a * b ;
    long lcm = product / gcd_euclid(a, b);

    return lcm;
  }


  private static int gcd_euclid(int a , int b){
    if(b == 0)
      return a;

    return gcd_euclid(b, a % b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
