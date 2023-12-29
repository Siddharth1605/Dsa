class Solution {
public:
    void rev(vector<int> &nums, int s, int e)
    {
        if(s<=e)
        {
            swap(nums[s], nums[e]);
            s++;
            e--;
            rev(nums, s, e);
        }
    }
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        int ind = -1;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i] < nums[i+1]) {ind = i;   break;}
        }

        if(ind == -1)
        {
            rev(nums, 0, n - 1);
        }
        else
        {
            int i;
            for(i=n-1;i>=0;i--)
            {
                if(nums[i]>nums[ind])   {break;}
            }

            swap(nums[i], nums[ind]);

            rev(nums, ind + 1, n - 1);

        }
    }
};