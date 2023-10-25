#include<bits/stdc++.h>
int kDistinctChars(int k, string s)
{
    unordered_map<char, int> mp;
    int j=0;
    int i=0;
    int unique = 0;
    int ans = 0;
    while(j<s.length())
    {
        mp[s[j]]++;

        while(mp.size() > k)
        {
            mp[s[i]]--;
            if(mp[s[i]] == 0)
                mp.erase(s[i]);
            i++;
        }
        ans = max(ans, j - i + 1);
        j++;
    }
    return ans;

}


