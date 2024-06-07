//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 


class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt(); 
            int arr[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int []ans= obj.sortArr(arr, n);
            for(int i=0;i<n;i++)
            {
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    void mergersort(int arr[],int s,int e){
        if(s >= e)return;
        int mid = s+(e-s)/2;
        mergersort(arr,s,mid);
        mergersort(arr,mid+1,e);
        merge(arr,s,mid,e);
    }
    void merge(int arr[],int s , int mid ,int e){
        int n1 = mid-s+1;
        int n2 = e-mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for(int i = 0; i < n1 ; i++)left[i] = arr[i+s];
        for(int j = 0 ; j < n2 ; j++)right[j] = arr[j+mid+1];
        int i =0;
        int j = 0;
        int k = s;
        while(i < n1 && j < n2){
            if(left[i] <= right[j])arr[k++] = left[i++];
            else arr[k++]=right[j++];
        }
        while(i < n1)arr[k++]=left[i++];
        while(j < n2)arr[k++]=right[j++];
    }
    int[] sortArr(int[] arr, int n) 
    { 
        // code here
        int ans[] = new int[n];
        mergersort(arr,0,n-1);
        for(int i = 0; i < n ; i++)ans[i] = arr[i];
        return ans;
    }
} 