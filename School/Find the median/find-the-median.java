//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v  = new int[n];
            for(int  i = 0; i < n; i++)
                v[i] = Integer.parseInt(S[i]);
            Solution ob = new Solution();
            int ans = ob.find_median(v);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int find_median(int[] v)
    {
        for(int i=0;i<v.length;i++){
            for(int j=i+1;j<v.length;j++){
                if(v[i]>v[j]){
                    int temp = v[i];
                    v[i]=v[j];
                    v[j]=temp;
                }
            }
        }
        if(v.length%2==1){
            return v[v.length/2];
        }else{
            return (v[v.length/2]+v[v.length/2-1])/2;
        }
    }
}