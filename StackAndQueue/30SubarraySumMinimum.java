import java.util.*;
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i=0;i<n;i++)
        {
            left[i] = i+1;
            right[i] = n-i;
        }

        Stack<AbstractMap.SimpleEntry<Integer, Integer>> leftst = new Stack<>();
        Stack<AbstractMap.SimpleEntry<Integer, Integer>> rightst = new Stack<>();

        for(int i=0;i<n;i++)
        {
            while(!leftst.isEmpty() && leftst.peek().getKey() > arr[i])    
                leftst.pop();
            left[i] = (leftst.isEmpty()) ? i + 1 : i - leftst.peek().getValue();
            leftst.push(new AbstractMap.SimpleEntry<>(arr[i], i));

            while(!rightst.isEmpty() && rightst.peek().getKey() > arr[i])
            {
                var x = rightst.pop();
                right[x.getValue()] = i - x.getValue();
            }
            rightst.push(new AbstractMap.SimpleEntry<>(arr[i], i));
        }

        int ans = 0;
        int mod = 1000000007;

        for(int i=0;i<n;i++)    
            ans = (ans + (int) ((long) arr[i] * left[i] * right[i] % mod)) % mod;
        return ans;
    }
}