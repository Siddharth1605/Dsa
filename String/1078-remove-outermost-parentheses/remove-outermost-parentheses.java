class Solution {
    public String removeOuterParentheses(String s) {
        int o = 0;
        String a = "";
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c == '(')
                o++;
            else
                o--;
            if((o>1 && c=='(') || (o >= 1 && c ==')'))
                a += c;
        }
       return a;
    }
}