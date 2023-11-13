class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> st = new Stack<>();
        if(n != popped.length)  return false;

        int i = 0;
        int j = 0;
        while(i<n && j<n)
        {
            while(i<n && pushed[i] != popped[j])
            {
                st.push(pushed[i]);
                i++;
            }

            if(i >= n)   return false;
            st.push(pushed[i]);
            i++;
            while(!st.isEmpty() && j<n && popped[j] == st.peek())
            {
                st.pop();
                j++;
            }
            //if(st.isEmpty())    return true;
        }

        return st.isEmpty();
    }
}