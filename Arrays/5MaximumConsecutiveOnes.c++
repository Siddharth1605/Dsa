class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int n = nums.size();
        int s = 0;
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            ans=s>ans?s:ans;
            if(nums[i] !=1) {s=0;}
            else    {s++;}
        }
        return ans>s?ans:s;
    }
};