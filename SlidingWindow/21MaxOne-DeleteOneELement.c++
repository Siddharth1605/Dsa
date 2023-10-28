class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int l = 0;
        int r = 0;
        int c = 0;
        int ans = 0;
        while( r < nums.size() )
        {
            if(nums[r] == 0) 
                c++;
            
            while(c > 1)
            {
                if(nums[l] == 0)
                    c--;
                l++;
            }
            if(c == 1)
                ans = max(ans, r - l);
            else
                ans = max(ans, r - l + 1);
            r++;
        }
        return (c == 0) ? ans - 1 : ans;
    }
};