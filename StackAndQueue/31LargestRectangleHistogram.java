class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int[] ps = new int[n];
        int[] ns = new int[n];
 
        Stack<Integer> prev = new Stack<>();
        Stack<Integer> next = new Stack<>();

        for(int i=0;i<n;i++)
        {
            while(!prev.isEmpty() && arr[prev.peek()] >= arr[i])
                prev.pop();
            
            if(prev.isEmpty())
                ps[i] = -1;
            else
                ps[i] = prev.peek();
            prev.push(i);
        }

        for(int i=n-1;i>=0;i--)
        {
            while(!next.isEmpty() && arr[next.peek()] >= arr[i] )
                next.pop();
            if(next.isEmpty())
                ns[i] = n ;
            else
                ns[i] = next.peek();
            
            next.push(i);
        }
        
        int x = 0;
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            x = (ns[i] - ps[i] - 1) * arr[i];
            ans = Math.max(ans, x);
        }
        return ans;
    }
}