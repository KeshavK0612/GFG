//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
    
        String[] words = sentence.split(" ");
        long ans = -1;
        
        for (String word : words) {
            if (isNumeric(word)) {
                long num = Long.parseLong(word);
                if (!hasNine(num)) {
                    ans = Math.max(ans, num);
                }
            }
        }
        
        return ans;
    }
    
    private boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean hasNine(long n) {
        while (n > 0) {
            if (n % 10 == 9) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
}