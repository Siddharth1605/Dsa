class Solution {
public:
    vector<int> getAverages(vector<int>& nums, int k) {
        int n = nums.size();
        if(k == 0)  return nums;
        long long sum = 0;
        int l = 0;
        int r = 0;
        vector<int> ans(n, -1);
        while(r<n)
        {
            sum += nums[r];
            if(r >= (2*k))
            {
                cout << sum << " " << k << endl;
                ans[r-k] = sum/(2*k+1);
                sum -= nums[l];
                l++;
            }
            r++;
        }   
        return ans;
    }
};