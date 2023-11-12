class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n = s.length();
        //if(n != t.length()) return false;

        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for(int i=0;i<n;i++)
        {
            if(s.charAt(i) == '#')
            {
                if(!st1.isEmpty())
                    st1.pop();
            }
            else
                st1.push(s.charAt(i));
        }

        n = t.length();
        for(int i=0;i<n;i++)
        {
            if(t.charAt(i) == '#')
            {
                if(!st2.isEmpty())
                    st2.pop();
            }
            else
                st2.push(t.charAt(i));
        }
        

        if(st1.size() != st2.size())    return false;

        while(!st1.isEmpty() && !st2.isEmpty())
        {
            if(st1.pop() != st2.pop())  return false;
        }
        return true;
    }
}