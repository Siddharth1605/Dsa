class Solution {
public:
    int countGoodSubstrings(string s) {
        set<char> st;
        int c = 0;
        int l = 0;
        int r = 0;
        while(r < s.length())
        {
            if(r >= 3)
            {
                if(st.size() == 3){  c++;
                st.erase(s[l]);
                l++;}
            }
            while(l<r && st.find(s[r]) != st.end())
            {
                st.erase(s[l]);
                l++;
            }
            st.insert(s[r]);
            r++;
        }
        if(st.size() == 3) c++;
        return c;
    }
};