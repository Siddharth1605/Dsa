class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> ans;
        deque<int> dq;
        for(int i=0;i<nums.size();i++)
        {
            while(!dq.empty() && i-k == dq.front()) dq.pop_front();

            while(!dq.empty() && nums[i] > nums[dq.back()]) dq.pop_back();
            dq.push_back(i);4

            if(i >= k-1 && !dq.empty())     ans.push_back(nums[dq.front()]);
        }
        return ans;
    }
};
