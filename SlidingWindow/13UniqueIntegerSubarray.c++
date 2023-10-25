class Solution {
public:
    int atmost(vector<int> &nums, int k)
    {
        int i=0;
        int j=0;
        int ans = 0;
        unordered_map<int, int> mp;

        for(j=0;j<nums.size();j++)
        {
            mp[nums[j]]++;

            while(mp.size() > k)
            {
                mp[nums[i]]--;
                if(mp[nums[i]] == 0)    
                    mp.erase(nums[i]);
                i++;
            }

            ans += j - i + 1;
        }
        return ans;
    }
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        int g = atmost(nums, k);
        int g1 = atmost(nums, k-1);
        cout << g << " " << g1;
        return g - g1;
    }
};