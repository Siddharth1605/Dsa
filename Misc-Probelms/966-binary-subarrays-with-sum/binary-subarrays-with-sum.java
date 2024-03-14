class Solution {
    public int numSubarraysWithSum(int[] arr, int g) {
        int n1 = atmost(arr, g-1);
        int n2 = atmost(arr, g);
        return n2 - n1;
    }
    public int atmost(int[] arr, int g)
    {
        if(g<0) return 0;
        int l = 0;
        int r = 0;
        int n = arr.length;
        int sum = 0;
        int ans = 0;
        while(r<n)
        {
            sum += arr[r];
            while(sum>g && l<n)
            {
                sum -= arr[l];
                l++;
            }
            ans += (r-l+1);
            r++;
        }
        return ans;
    }
}