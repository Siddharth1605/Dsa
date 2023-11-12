class Solution {
    public int calPoints(String[] arr) {
        Stack<Integer> st =  new Stack<>();

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].equals("C"))
            {
                st.pop();
            }
            else if(arr[i].equals("D"))
            {
                int y = st.peek();
                st.add(2 * y);
            }
            else if(arr[i].equals("+"))
            {
                int x = st.pop();
                int y = st.peek();
                st.add(x);
                st.add(x + y);
            }
            else
            {
                st.add(Integer.parseInt(arr[i]));
            }
        }
        int sum = 0;
        while(!st.isEmpty())
            sum += st.pop();
        return sum;
    }
}