//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
   static int countSetBits(int n) {
        if (n == 0)
            return 0;
        
        // Calculate the largest power of 2 less than or equal to n
        int x = largestPowerOf2(n);
        
        // Count bits in the first 2^x numbers
        int bitsTill2x = x * (1 << (x - 1));
        
        // Count the remaining bits from 2^x to n
        int msbFrom2xToN = n - (1 << x) + 1;
        
        // Recursively count bits in the remaining part
        int rest = n - (1 << x);
        
        return bitsTill2x + msbFrom2xToN + countSetBits(rest);
    }
    
    // Function to find the largest power of 2 less than or equal to n
    static int largestPowerOf2(int n) {
        int x = 0;
        while ((1 << x) <= n) {
            x++;
        }
        return x - 1;
    }
}

//{ Driver Code Starts.

// Driver code
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();//input n

		    Solution obj = new Solution();

		    System.out.println(obj.countSetBits(n));//calling countSetBits() method
		}
	}
}

// } Driver Code Ends