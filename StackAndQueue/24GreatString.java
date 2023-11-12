class Solution {
    public boolean charCompare(char a, char b) {
return Math.abs(a - b) == 'a' - 'A';
}

    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            if(!st.isEmpty() && charCompare(st.peek(), s.charAt(i)))
                st.pop();
            else
                st.push(s.charAt(i));
        }
        String r = "";
        while(!st.isEmpty())
            r += st.pop();

        String t = "";
        for(int i=r.length() - 1;i>=0;i--)
            t += r.charAt(i);

        return t;
    }
}