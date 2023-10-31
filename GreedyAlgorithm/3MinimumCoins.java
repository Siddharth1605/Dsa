import java.util.*;
public class Solution {
    public static List<Integer> MinimumCoins(int n) {
        // Write your code here.
        int[] arr = {1, 2, 5, 10, 20, 50, 100 ,500, 1000};
        ArrayList<Integer> ans = new ArrayList<>();

        int s = arr.length;
        for(int i=s-1;i>=0;i--)
        {
            while(arr[i] <= n)
            {
                ans.add(arr[i]);
                n-=arr[i];
            }
            if(n == 0)
                break;
        }
        
        return ans;
    }
}
