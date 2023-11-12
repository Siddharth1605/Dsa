class Solution {
    public int[] finalPrices(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i=n-1;i>=0;i--)
        {      
            while(!st.isEmpty() && st.peek() > arr[i])
                st.pop();
                
            if(!st.isEmpty())
                ans[i] = arr[i] - st.peek();

            else
                ans[i] = arr[i];

            st.push(arr[i]);
        }

        return ans;
    }
}