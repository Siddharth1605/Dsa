#include<bits/stdc++.h>
int subarraysWithSumK(vector < int > a, int b) {
    // Write your code here
    map<int, int> hash;
    int n = a.size();
    int s = 0;
    int x = 0;
    int c = 0;
    hash[0] = 1;
    for(int i=0;i<n;i++)
    {
        s^=a[i];
        x = s ^ b;
        if(hash.find(x) != hash.end())
            c+=hash[x];
        hash[s]++;
    }
    return c;
}