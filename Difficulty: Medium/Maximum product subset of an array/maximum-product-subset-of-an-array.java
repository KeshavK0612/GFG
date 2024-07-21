//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public long findMaxProduct(List<Integer> arr) {
        // code here
        if (arr.size() == 1) return arr.get(0);
        int maxNeg = Integer.MIN_VALUE, zero=0, nonZero=0;
        long ans = 1;
        for(int i:arr){
            if(i!=0){
                nonZero = 1;
                ans = (ans*i)%1000000007; 
            }
            else zero = 1;
            if(i<0 && i>maxNeg) maxNeg = i;
        }
        if(nonZero!=1) return 0;
        if(arr.size()==2 && zero==1 && ans<0) return 0; 
        if(ans<0) ans /= maxNeg;
        return ans;
    }
}