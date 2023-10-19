class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int l = 0;
        int ans = 0;
        set<char> st;
        for(int r=0;r<s.length();r++)
        {

            while(l<r && st.find(s[r]) != st.end())
            {
                st.erase(s[l]);
                l++;
            }
            st.insert(s[r]);
            ans = max(ans, r - l + 1);
        }
        return ans;
        
    }
};