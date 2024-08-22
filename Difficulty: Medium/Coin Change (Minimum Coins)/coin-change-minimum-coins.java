//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int v = sc.nextInt();
            int m = sc.nextInt();
            int coins[] = new int[m];
            for (int i = 0; i < m; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minCoins(coins, m, v));
        }
    }
}
// } Driver Code Ends


class Solution {

    public int minCoins(int coins[], int M, int sum) {
        // Your code goes here
         int[] minCoins = new int[sum + 1];
        Arrays.fill(minCoins, sum + 1);
        minCoins[0] = 0;

        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coins[j]]);
                }
            }
        }

        return minCoins[sum] != sum + 1 ? minCoins[sum] : -1;      
    }
}