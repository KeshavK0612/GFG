//{ Driver Code Starts
import java.util.*;
class PalindromicArray{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0 ;i < n; i++)
				a[i]=sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.palinArray(a , n));
		}
	}
}
// } Driver Code Ends


/*Complete the Function below*/
class GfG
{
	public static int palinArray(int[] a, int n)
           {
                for(int i=0;i<n;i++)
        {
            int k=a[i];
            int num1=k;
            int rev=0;
            while(k!=0)
            {
                rev=rev*10+k%10;
                k=k/10;
            }
            if(num1!=rev)
            {
                return 0;
            }
        }
        return 1;
               
           }
}