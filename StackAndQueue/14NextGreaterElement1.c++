class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
      stack<int>st;

        int n = nums2.size();
        map<int, int> m;
        for(int i=n-1;i>=0;i--)
        {
            while(!st.empty() && st.top() <= nums2[i])
            {
                st.pop();
            }
           if(!st.empty()) m[nums2[i]] = st.top();
           else m[nums2[i]] = -1;
            st.push(nums2[i]);
        }
        vector<int> ans;
        for(int i=0;i<nums1.size();i++)
        {
            ans.push_back(m[nums1[i]]);
        }
        return ans;
    }
};