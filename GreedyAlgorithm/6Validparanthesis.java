public class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> lt = new Stack<>();
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(')
                lt.push(i);
            else if(s.charAt(i) == '*')
                st.push(i);
            else
            {
                if(lt.empty() && st.empty())    return false;
                if(!lt.empty())
                    lt.pop();
                else
                    st.pop();
            }
        }

        while(!lt.isEmpty() && !st.empty())
        {
            if(lt.pop() > st.pop())
                return false;
        }
        return lt.empty();
    }
} {
    
}
