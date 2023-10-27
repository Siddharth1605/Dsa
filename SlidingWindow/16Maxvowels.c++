class Solution {
public:
bool isVowel(char c) {
    c =tolower(c);
    
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}
    int maxVowels(string s, int k) {
        int r = 0;
        int ans = 0;
        int c = 0;
        while(r<s.length())
        {
            char ch = s[r];
            if(isVowel(ch))    c++;
            if(r>=k-1)
            {
                ans = max(ans, c);
                if(isVowel(s[r-k+1])) c--;
            }
            r++;
        }
        return ans;
    }
};