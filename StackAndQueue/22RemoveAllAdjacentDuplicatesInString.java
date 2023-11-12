class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<n;i++)
        {
            if(!st.isEmpty() && st.peek()==s.charAt(i))
                st.pop();
            else
                st.push(s.charAt(i));
        }

        String ans = "";
        while(!st.isEmpty())
            ans += st.pop();
        
        String originalString = ans;
        StringBuilder reversedStringBuilder = new StringBuilder(originalString).reverse();
        String reversedString = reversedStringBuilder.toString();

        return reversedString;
    }
}