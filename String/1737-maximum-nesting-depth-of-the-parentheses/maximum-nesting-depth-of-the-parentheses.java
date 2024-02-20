class Solution {
    public int maxDepth(String s) {
        int o = 0;
        int ans = 0;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c == '(')    
                o++;
            else if(c == ')')
                o--;
            ans = Math.max(ans, o);
        }
        return ans;
    }
}