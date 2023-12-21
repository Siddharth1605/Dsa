class Solution {
    public static int count(int n, List<Integer> ds, int[] freq)
    {
        int ans = 0;
        if(ds.size() == n)
        {
            return 1;
        }
        for(int i=1;i<=n;i++)
        {
            if(freq[i-1] == 0)
            {
                int x = ds.size() + 1;
                if(x%i==0 || i%x==0)
                {
                    freq[i-1] = 1;
                    ds.add(i);

                    ans += count(n, ds, freq);
                    
                    ds.remove(ds.size() - 1);
                    freq[i-1] = 0;
                }
                 
            }
        }
        return ans;
    }
    public int countArrangement(int n) {
        List<Integer> ds = new ArrayList<>();
        int[] freq = new int[n];
        Arrays.fill(freq, 0);
        return count(n, ds, freq);
    }
}