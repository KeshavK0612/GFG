//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
         int n = mat.length;
        int candidate = 0;

        // Step 1: Find the celebrity candidate
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
             //so candidate cannot be a celebrity
                candidate = i;
            }
        }

        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            // Candidate should not know anyone else
            if (i != candidate && mat[candidate][i] == 1) {
                return -1;  //hence not a celebrity
            }
            // Everyone else should know the candidate
            if (i != candidate && mat[i][candidate] == 0) {
                return -1; 
            }
        }

        return candidate;
    }
}