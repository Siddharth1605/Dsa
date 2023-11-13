import java.util.*;
class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        Stack<AbstractMap.SimpleEntry<Integer, Integer>> st = new Stack<>();
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[i] >= st.peek().getKey())
                st.pop();

            if(st.isEmpty())
                ans[i] = 0;
            
            else
                ans[i] = st.peek().getValue() - i;
            
            st.push(new AbstractMap.SimpleEntry(arr[i], i));
        }

        return ans;
    }
}