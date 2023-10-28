class Solution {
public:
    int minimumCardPickup(vector<int>& cards) {
        int r = 0;
        int l = 0;
        int ans = INT_MAX;
        map<int, int> mp;
        while(r < cards.size())
        {
            mp[cards[r]]++;

            while(mp[cards[r]] > 1)
            {
                mp[cards[l]]--;
                ans = min(ans, r-l+1);
                l++;
            }
            r++;
        }
        return (ans == INT_MAX) ? -1 : ans;
    }
};