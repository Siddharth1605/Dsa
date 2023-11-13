class Solution {
    public int minLength(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            if(!st.isEmpty() && ((st.peek() == 'A' && c == 'B') || (st.peek() =='C' && c == 'D')))
                st.pop();
            else
                st.push(c);
        }

        return st.size();
    }
}