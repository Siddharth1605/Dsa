class Solution {
public:
    int minimumRecolors(string s, int k) {
        int r = 0;
        int z = 0;
        int c = 0;
        int l = 0;
        int ans = INT_MAX;
        while(r<s.length())
        {
            if(s[r] == 'W') c++;
            z++;

            while(z > k)
            {
                if(s[l] == 'W') c--;
                l++;
                z--;
            }
            if(z == k)  ans = min(ans, c);
            r++;
        }
        return (ans==INT_MAX)?c:ans;
    }
};