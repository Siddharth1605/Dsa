class Solution {
public:
    int numberOfSubstrings(string s) {
         int start = 0;
         int end = 0;
         int count = 0;
         unordered_map<char, int> m;
         for(int i=0;i<s.length();i++)
         {
             m[s[i]]++;
             while(m['a'] && m['b'] && m['c'])
             {
                count += s.length() - i;
                m[s[start]]--;
                start++;
             }

         }
         return count;
    }
};