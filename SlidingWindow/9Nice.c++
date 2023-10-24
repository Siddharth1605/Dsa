class Solution {
public:
    int atmost(vector<int> &nums, int k)
    {
        int i = 0;
        int j = 0;
        int ans = 0;
        int sum = 0;
        while(j<nums.size())
        {
            if(nums[j] == 1) sum += nums[j];

            while(sum > k)
            {
                sum -= nums[i];
                i++;
            }
            ans += (j-i+1);
            j++;
        }
        return ans;
    }
    int numberOfSubarrays(vector<int>& nums, int k) {
         for(int i = 0; i < nums.size(); i++)
        {
            if(nums[i] % 2 == 1) nums[i] = 1;
            else nums[i] = 0;
        }
        int g = atmost(nums, k);
        int g1 = atmost(nums, k-1);
        return g - g1;
    }
};