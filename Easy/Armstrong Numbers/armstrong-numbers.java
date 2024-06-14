//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String armstrongNumber(int n){
        // code here
        int original_n=n;
        double hundreds_place=Math.floor(n/100);
        n=n%100;
        double tens_place=Math.floor(n/10);
        n=n%10;
        double armstrong_num=Math.pow(hundreds_place,3)+Math.pow(tens_place,3)+Math.pow(n,3);
        if(armstrong_num==original_n) return "true";
        else return "false";
        
    }
}