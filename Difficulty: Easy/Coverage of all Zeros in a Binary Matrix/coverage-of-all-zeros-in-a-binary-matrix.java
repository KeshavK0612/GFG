//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.findCoverage(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    public int findCoverage(int[][] matrix) {

    int row = matrix.length;

    int column = matrix[0].length;

    int sum = 0;

 

    for (int i = 0; i < row; i++) {

        for (int j = 0; j < column; j++) {

            int cur = matrix[i][j];

 

            //Check the Current element is not on the boundary of matrix in right side for prevent form the error of: "ArrayIndexOutOfBoundsException"

            if (j < column - 1) {

             

                if (cur != matrix[i][j + 1]) {

                    sum++;

                }

            }

 

            

            if (i < row - 1) {

                if (cur != matrix[i + 1][j]) {

                    sum++;

                }

            }

        }

    }

    

    return sum;

 

    }

}