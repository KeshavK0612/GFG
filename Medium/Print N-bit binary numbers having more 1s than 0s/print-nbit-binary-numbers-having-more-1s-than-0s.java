//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        int oneCount = 0, zeroCount = 0;
        StringBuilder sb = new StringBuilder();
        recursion(sb,N,oneCount,zeroCount,ans);
        return ans;
    }
    
    void recursion(StringBuilder str,int N,int oneCount,int zeroCount,ArrayList<String> ans ){
        //base case
        if(N == 0){
            if(oneCount >= zeroCount){
                ans.add(str.toString());
            }
            return;
        }
        str.append("1");
        recursion(str,N-1,oneCount+1,zeroCount,ans);
        str.deleteCharAt(str.length() - 1);
        
        if(oneCount > zeroCount){
            str.append("0");
            recursion(str,N-1,oneCount,zeroCount+1,ans);
            str.deleteCharAt(str.length() - 1);
        }
    }
}