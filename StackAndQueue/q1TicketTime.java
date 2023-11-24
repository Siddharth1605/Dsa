class Solution {
    public int timeRequiredToBuy(int[] arr, int k) {
        Queue<int []> q = new LinkedList<>();

        for(int i=0;i<arr.length;i++)
            q.add(new int[] {arr[i], i});

        int c = 0;

        while(!q.isEmpty() && arr[k] != 0)
        {
            if(q.peek()[0] > 0)
            {
                int x = q.peek()[0] - 1;
                int i = q.peek()[1];
                if(k == i)
                    arr[k] = x;
                q.poll();
                q.add(new int[] {x, i});
                c++;
            }
            else
                q.poll();
        }

        return c;
    }
}