class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int res = 0;
        int n = cardPoints.size();
        for(int i=0;i<k;i++)    res += cardPoints[i];
        int cur = res;
        for(int i=k-1;i>=0;i--)
        {
            cur -= cardPoints[i];
            cur += cardPoints[n - k + i];
            res = max(cur, res);
        }
        return res;
    }
};