class Solution {
    public int shipWithinDays(int[] arr, int days) {
        int mini = Integer.MIN_VALUE;
        int maxi = 0;
        for(int i=0;i<arr.length;i++)
        {
            maxi += arr[i];
            mini = Math.max(mini, arr[i]);
        }
        int low = mini;
        int high = maxi;
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            if(fun(arr, mid) <= days)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
    public static int fun(int[] arr, int l)
    {
        int d = 1;
        int w = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(w + arr[i] <= l)
            {
                w += arr[i];
            }
            else
            {
                d++;
                w = arr[i];
            }
        }
        return d;
    }
}