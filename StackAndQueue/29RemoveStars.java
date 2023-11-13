class Solution {
    public String removeStars(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(!st.isEmpty() && s.charAt(i) == '*')
                st.pop();
            else if(st.isEmpty() || s.charAt(i) != '*')
                st.push(s.charAt(i));
        }

        String r = "";
        while(!st.isEmpty())
            r += st.pop();

        String str = "";
        for(int i=r.length() - 1;i>=0;i--)
            str += r.charAt(i);

        return str;
    }
}