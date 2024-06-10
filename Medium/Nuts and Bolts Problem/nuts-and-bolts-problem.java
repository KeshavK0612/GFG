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
            int n = Integer.parseInt(br.readLine().trim());
            char[] nuts = new char[n], bolts = new char[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                nuts[i] = (inputLine[i].charAt(0));
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                bolts[i] = (inputLine[i].charAt(0));
            }

            new Solution().matchPairs(n, nuts, bolts);
            for (int i = 0; i < n; i++) {
                System.out.print(nuts[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(bolts[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
        // Define the order of characters
        char[] order = {'!', '#', '$', '%', '&', '*', '?', '@', '^'};
        
        // Create a map to store the order index
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length; ++i) {
            orderMap.put(order[i], i);
        }
        
        // Convert char arrays to Character arrays
        Character[] nutsArr = new Character[n];
        Character[] boltsArr = new Character[n];
        for (int i = 0; i < n; i++) {
            nutsArr[i] = nuts[i];
            boltsArr[i] = bolts[i];
        }

        // Sort nuts based on the predefined order
        Arrays.sort(nutsArr, Comparator.comparingInt(orderMap::get));
        
        // Sort bolts based on the predefined order
        Arrays.sort(boltsArr, Comparator.comparingInt(orderMap::get));

        // Convert Character arrays back to char arrays
        for (int i = 0; i < n; i++) {
            nuts[i] = nutsArr[i];
            bolts[i] = boltsArr[i];
        }
    }
}