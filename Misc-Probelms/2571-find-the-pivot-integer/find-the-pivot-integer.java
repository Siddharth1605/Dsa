class Solution {
    public int pivotInteger(int n) {
        int total = n*(n+1)/2;
        for(int i=1;i<=n;i++)
        {
            int p = i - 1;
            int prev = p*(p+1)/2;
            int cur = i*(i+1)/2;
            int rem = total - prev;
            if(rem == cur)
                return i;
         }
        return -1;
    }
}