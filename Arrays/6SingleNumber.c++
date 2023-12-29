class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int n = nums.size();
        int x1 = 0;
        for(int i=0;i<n;i++)
        {   x1=x1^nums[i];  }
        return x1;
    }
};