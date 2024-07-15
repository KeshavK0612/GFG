//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends


 class Solution {
     
    int digitSum(int n) {
        int x = 0;
        while (n > 0) {
            x += n % 10;
            n /= 10;
        }
        return x;
    }
    public String smallestNumber(int s, int d) {
        for (int num = (int) Math.pow(10, d - 1); num < (int) Math.pow(10, d); num++) {
            if (digitSum(num) == s) {
                return Integer.toString(num);
            }
        }
        return "-1";
    }

}
