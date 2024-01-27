class Solution {
    public int maximumCandies(int[] arr, long k) {
        int maxi = 0;
        int sum = 0;
        for(int i=0;i<arr.length;i++)
        {
            maxi = Math.max(maxi, arr[i]);
            sum += arr[i];
        }

         
        /*
        Time Complexity: O(n * max(arr[i]))
        for(int i=maxi;i>=1;i--)
        {
            if(fun(arr, i) >= k)
                return  i;
        }*/

        //O(n * log(max(arr[i])))
        int start = 1;
        int high = maxi;
        boolean flag = false;
        while(start <= high)
        {
            int mid = start + (high-start)/2;
            if(fun(arr, mid) < k)
                high = mid - 1;
            else
            {
                flag = true;
                start = mid + 1;
            }
        }
        if(!flag)
            return 0;
        return high;
    }
    public static long fun(int[] arr, int k)
    {
        long ct = 0;
        for(int i=0;i<arr.length;i++)
            ct += arr[i]/k;
         return ct;
    }
}