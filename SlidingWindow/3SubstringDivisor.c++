class Solution {
public:
    int divisorSubstrings(int n, int k) {
        string x = to_string(n);
        int num = 0;
        int c = 0;
        string a = "";
        for(int i=0;i<x.length();i++)
        {
            if(i>=k)
            {
                num = stoi(a);
                if(num != 0 && n % num == 0)    c++;
                a = a.substr(1, k - 1);
            }
            a += x[i];
        }
        num = stoi(a);
        if(num != 0 && n % num == 0)    c++;
        return c;
    }
};