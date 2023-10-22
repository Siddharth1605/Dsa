class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int l = 0;
        int z = 0;
        int ans = INT_MIN;
        for(int r=0;r<nums.size();r++)
        {
            if(nums[r] == 0)    z++;

            while(z>k)
            {
                if(nums[l] == 0) {z--;}
                l++;
            }
            ans = max(ans, r - l + 1);
        }
        
        return ans;
    }
};