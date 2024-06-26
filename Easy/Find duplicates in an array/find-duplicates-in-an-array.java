//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        
        HashMap <Integer,Integer> map = new HashMap <> ();
        for(int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }

        
        ArrayList <Integer> list = new ArrayList<> ();
        for(int num : map.keySet()){
            if(map.get(num)>1){
                list.add(num);
            }
        }
        if(list.isEmpty()){
            list.add(-1);
        }
        else{
        Collections.sort(list);
            
        }
        return list;
    }
}
