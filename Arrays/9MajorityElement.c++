class Solution {
public:
    int majorityElement(vector<int>& arr) {
        int el = 0;
        int n = arr.size();
        int c = 0;
        for(int i=0;i<n;i++)
        {
            if(c == 0)
            {
                el = arr[i];
                c++;
            }
            else if(el == arr[i])   c++;
            else    c--;
        }
        c = 0;
        for(int i=0;i<n;i++)
        {
            if(el == arr[i])    c++;
        }
        if(c > n/2) return el;
        return -1;
    }
};