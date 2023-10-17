class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        set<int> st;
        for(int i=0;i<nums.size();i++)
        {
            if(i>=k+1)
            {
                st.erase(nums[i-(k+1)]);
            }
            if(st.find(nums[i]) != st.end())
                return true;

            st.insert(nums[i]);
        }
        return false;
    }
};