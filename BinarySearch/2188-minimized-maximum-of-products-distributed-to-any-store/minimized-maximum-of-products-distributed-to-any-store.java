class Solution {
    public int minimizedMaximum(int n, int[] arr) {
        int maxi = 0;
        for(int i=0;i<arr.length;i++)
            maxi = Math.max(maxi, arr[i]);
        int l = 1;
        int h = maxi;
        while(l<=h)
        {
            int m = l + (h-l)/2;
            if(fun(arr, m, n))
                h = m-1;
            else
                l = m + 1;
        }
        return l;
    }
    public static boolean fun(int[] arr, int g, int n)
    {
        int possiblestores=0;
        for(int i=0;i<arr.length;i++)
        {
            possiblestores += (int)Math.ceil((double)arr[i]/g);
        }
        return possiblestores <= n;
    }
}