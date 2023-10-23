class Solution {
public:
    int characterReplacement(string s, int k) {
        int count[26] = {0};
        int maxcount = 0;
        int maxlength = 0;
        int start = 0;
        for(int end=0;end<s.length();end++)
        {
            maxcount = max(maxcount, ++count[s[end] - 'A']);

            while(end - start + 1 - maxcount > k)
            {
                count[s[start] - 'A']--;
                start++;
            }

            maxlength = max(maxlength, end - start + 1);
        }
        return maxlength;
    }
};