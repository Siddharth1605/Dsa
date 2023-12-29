class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int x1 = 0;
        int x2 = 0;
        for(int i=0;i<nums.size();i++)
        {
            x1 = x1^nums[i];
            x2 = x2^(i+1);
        }
        return x1^x2;
    }
};
