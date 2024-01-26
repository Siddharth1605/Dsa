class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int maxv = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i=0;i<n;i++)
            maxv = Math.max(maxv, arr[i]);
        
        int start = 1;
        int end = maxv;

        while(start <= end)
        {
            int mid =  start + (end - start) / 2;
            int time = fun(arr, mid);
            if(time > h)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }
    public static int fun(int[] arr, int h)
    {
        int t = 0;
        for(int i=0;i<arr.length;i++)
        {
            t += Math.ceil((double)arr[i] /(double) h);
        }
        return t;
    }
}