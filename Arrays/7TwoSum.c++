class Solution {
public:
    vector<int> twoSum(vector<int>& arr, int t) {
        vector<int> ans;
        map<int, int> m;
        for(int i=0;i<arr.size();i++)
        {
            if(m.find(t - arr[i]) != m.end())
            {
                ans.push_back(m[t - arr[i]]);
                ans.push_back(i);
                break;
            }
            m[arr[i]] = i;
        }
        return ans;
        
    }
};