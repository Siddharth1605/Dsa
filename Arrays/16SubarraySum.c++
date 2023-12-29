class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int s = 0;
        int c = 0;  
        map<int,int> m;
        m[0] = 1;
        for(int i=0;i<nums.size();i++)
        {
            int it = nums[i];
            s+=it;
             c+=m[s-k];
            m[s]+=1;
        }
        return c;

       
    }
};