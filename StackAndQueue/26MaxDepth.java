class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int c = 0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i) == '(')
            {
                st.push(s.charAt(i));
                c++;
            }
            else if(s.charAt(i) == ')')
            {
                st.pop();
                ans = Math.max(ans, c);
                c--;
            }
            else 
                continue;
        }
        return ans;
    }
}