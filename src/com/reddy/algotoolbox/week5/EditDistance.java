package com.reddy.algotoolbox.week5;

import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    //write your code here
    /**
     * u convert s (i) to t(j)
     * cost for insertion, delettion, replace is 1
     */
    int m = t.length();
    int n = s.length();

    //char[] sarr = s.toCharArray();
   // char[] tarr = t.toCharArray();

    char[] sarr = new char[n+1];
    char[] tarr = new char[m+1];


    int[][] dis = new int [n+1][m+1];
    // fill in the initial arrays, assuming a empty string how many
    // steps it will take
    for (int l = 0; l <= n; l++) {
        dis[l][0] = l;
        if(l > 0 ){
          sarr[l] = s.charAt(l-1);
        }
    }

    for (int r = 0; r <=m ; r++) {
        dis[0][r] = r;
        if(r > 0){
          tarr[r] = t.charAt(r-1);
        }
    }
    for (int j = 1; j <= m; j++) {
      for (int i = 1; i <= n ; i++) {
          int match = dis[i-1][j-1];
          int mismatch = dis[i-1][j-1] + 1;//replace
          int deletion = dis[i-1][j] + 1;
          int insertion = dis[i][j-1] + 1;

          if(sarr[i] == tarr[j]){
            dis[i][j] = min(match, deletion, insertion);
          }else {
            dis[i][j] = min(mismatch, deletion, insertion);
          }
      }
    }
    return dis[n][m];
  }

  private static int min(int a, int b, int c){
    if(a < b && a <c){
      return a;
    }else if(b < c){
      return b;
    }

    return c;
  }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
