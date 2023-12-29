class Solution {
public:
    vector<int> majorityElement(vector<int>& arr) {
        int n = arr.size();
        int n1 = -1;
        int n2 = -1;
        int c1 = 0;
        int c2 = 0;
        int el = 0;
        for(int i=0;i<n;i++)
        {
            el = arr[i];
            if(el == n1)    c1++;
            else if(el == n2)   c2++;
            else if(c1 == 0)    {n1 = el;   c1=1;}
            else if(c2 == 0)    {n2 = el;   c2=1;}
            else    {c1--;  c2--;}
        }

        c1 = 0;
        c2 = 0;

        vector<int> ans;
        for(int i=0;i<n;i++)
        {
            if(n1 == arr[i])    c1++;
            else if(n2 == arr[i])   c2++;
        }

        if(c1>floor(n/3))  {ans.push_back(n1);}
        if(c2>floor(n/3))  {ans.push_back(n2);}

        return ans;
    }
};