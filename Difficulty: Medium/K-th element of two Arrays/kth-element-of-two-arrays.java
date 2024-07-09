//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement(int arr1[], int arr2[], int n1, int n2, int k) {
    // If n1 is bigger, swap the arrays to ensure n1 <= n2
    if (n1 > n2) {
        return kthElement(arr2, arr1, n2, n1, k);
    }

    int low = Math.max(0, k - n2), high = Math.min(k, n1);
    while (low <= high) {
        int mid1 = (low + high) / 2;
        int mid2 = k - mid1;
        
        // Calculate l1, l2, r1, and r2
        int l1 = (mid1 > 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE;
        int l2 = (mid2 > 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE;
        int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;
        int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;

        if (l1 <= r2 && l2 <= r1) {
            return Math.max(l1, l2);
        } else if (l1 > r2) {
            high = mid1 - 1;
        } else {
            low = mid1 + 1;
        }
    }
    return 0; // This line is never reached if inputs are valid
}

}