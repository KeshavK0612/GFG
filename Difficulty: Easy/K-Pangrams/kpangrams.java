//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public boolean kPangram(String str, int k) {
        // Remove spaces and convert to lowercase
        String s = str.replaceAll(" ", "").toLowerCase();

        // If length is less than 26, it cannot be a pangram
        if (s.length() < 26) return false;

        // Use a set to count unique characters
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        // Check if the number of unique characters plus k is at least 26
        return set.size() + k >= 26;
        
    }
}