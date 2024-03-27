class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)
            return 0;
        int l = 0;
        int n = nums.length;
        int r = 0;
        int pro = 1;
        int ans = 0;
        while(r<n)
        {
            pro *= nums[r];
            while(l<n && pro >= k)
            {
                pro /= nums[l];
                l++;
            }
            ans += (r - l + 1);
            r++;
        }
        return ans;
    }
}