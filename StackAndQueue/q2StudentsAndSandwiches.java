class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();

        int n = sandwiches.length;

        for(int i=0;i<n;i++)
        {
            q.add(students[i]);
            st.push(sandwiches[n-i-1]);
        }

        int c = 0;

        while(!q.isEmpty())
        {
            if(q.peek() == st.peek())
            {
                q.poll();
                st.pop();
                c = 0;
                n = q.size();
            }
            else
            {
                q.add(q.poll());
                c++;
                if(c>n) break;
            }
        }
        
        return q.size();

    }
}