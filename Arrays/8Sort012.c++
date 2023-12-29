class Solution {
public:
    void sortColors(vector<int>& arr) {
        int n = arr.size();
        int l = 0;
        int m = 0;
        int h = n-1;
        while(m<=h)
        {
            if(arr[m] == 0)
            {
                int t = arr[l];
                arr[l] = arr[m];
                arr[m] = t;
                l++;
                m++;
            }
            else if(arr[m] == 1)
            {
                m++;
            }
            else if(arr[m] == 2)
            {
                int t = arr[m];
                arr[m] = arr[h];
                arr[h] = t;
                h--;
            }
        }
    }
};