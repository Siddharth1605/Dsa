class Solution {
public:
    int maxSubArray(vector<int>& arr) {
        int s = 0;
        int n = arr.size();
        int maxi = INT_MIN;
        for(int i=0;i<n;i++)
        {
            s+=arr[i];
            maxi = s>maxi?s:maxi;
            if(s<0) {s=0;}
        }
        return maxi;
    }
};