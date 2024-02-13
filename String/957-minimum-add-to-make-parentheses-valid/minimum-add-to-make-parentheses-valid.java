class Solution {
    public int minAddToMakeValid(String s) {
        //Time Complexity : O(N)
        int c= 0;
        int i = 0;
        int k = s.length() - 1;
        int req = 0;
        while(i<s.length() && s.charAt(i) == ')')
        {
            req++;
            i++;
        }
        while(k>=0 && s.charAt(k) == '(')
        {
            req++;
            k--;
        }
        while(i <= k)
        {
            if(c == 0 && s.charAt(i) == ')')
                req++;
            else if(s.charAt(i) == '(')
                c++;
            else if(s.charAt(i) == ')')
                c--;
            i++;
        }
        return req + Math.abs(c);
    }
    //Time Complexity: O(N) Space Complexity: O(N)
    public static int fun(String s)
    {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c == '(')
                st.add(c);
            else if(c == ')' && !st.isEmpty() && st.peek() == '(')
                st.pop();
            else
                return s.length() - i;
        }
        return st.size();
    }
}