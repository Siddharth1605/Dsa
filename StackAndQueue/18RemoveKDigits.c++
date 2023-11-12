class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        int n = num.length();

        for(int i=0;i<n;i++)
        {
            while(k>0 && !st.isEmpty() && st.peek() > num.charAt(i))
            {
                st.pop();
                k--;
            }

            if(!st.isEmpty() || num.charAt(i) != '0')
                st.add( num.charAt(i));
        }

        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }
        if(st.isEmpty())    return "0";
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.insert(0, st.pop());
        }

        return result.toString();
    }
}