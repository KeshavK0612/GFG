//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
     public int[] twoOddNum(int arr[], int N) {
        // code here
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        int count = 0;
        while (xor != 0) {
            if ((xor & 1) == 0) {
                count++;
            } else {
                break;
            }
            xor = xor >> 1;
        }
        int bitmask = 1 << count;
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((bitmask & arr[i]) == 0) {
                xor2 ^= arr[i];
            } else {
                xor1 ^= arr[i];
            }
        }
        int nums[] = {Math.max(xor1,xor2),Math.min(xor1,xor2)};
        return nums;
    }
}