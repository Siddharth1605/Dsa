class Solution {
public:
    int numOfSubarrays(vector<int>& arr, int k, int t) {
        int r = 0;
        int l = 0;
        int c = 0;
        int s = 0;
        while(r < arr.size()) 
        {
            s += arr[r];
            if(r >= k - 1)
            {
                if(s/k >= t) c++;
                s -= arr[l];
                l++;
            }
            r++;
        }
        return c;
    }
};