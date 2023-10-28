class Solution {
public:
    int minSubArrayLen(int t, vector<int>& nums) {
        int r = 0;
        int l = 0;
        int ans = INT_MAX;
        int sum = 0;
        while(r<nums.size())
        {
            sum += nums[r];
            while(sum >= t)
            {
                ans = min(ans, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return (ans == INT_MAX) ? 0 : ans;
    }
};