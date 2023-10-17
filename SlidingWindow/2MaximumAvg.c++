class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        double ans = INT_MIN ;
        double s = 0;
        for(int i=0;i<nums.size();i++)
        {
            if(i>=k)
            {
                double avg = s/k;
                ans = max(ans, avg);
                s -= nums[i-k];
            }
            s += nums[i];
        }
        double avg = s/k;
                ans = max(ans, avg);
        return ans;
    }
};