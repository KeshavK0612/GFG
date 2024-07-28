//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int index = -1;
        int cnt_max = 0;
        int n = arr.length;
        int m = arr[0].length;
     
        
        for(int i = 0; i < n; i++){
            
            int cnt_ones = m - lowerBound(arr[i], m);
        
            if(cnt_ones > cnt_max){
                
                cnt_max = cnt_ones;
                index = i;
            }
            
        }
        return index;
    }
    
    public int lowerBound(int[] a, int n){
        int low = 0; int high = n-1;
        int x = 1; int ans = n;
        
        while(low<=high){
            
            int mid = (high+low)/2;
            
            if(a[mid]>=x){
                ans = mid;
                high = mid-1;
            }else low = mid+1;
        }
       
        return ans;
    }
}