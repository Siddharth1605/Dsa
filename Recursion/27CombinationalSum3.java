class Solution {
    public static List<List<Integer>> fun(int ind, int n, int k, List<Integer> ds)
    {
        List<List<Integer>> ans = new ArrayList<>();
        if(k == 0)
        {
            if(ds.size() == n)
                ans.add(new ArrayList<>(ds));
            return ans;
        }
        if(ds.size() > n)
            return ans;
        for(int i=ind;i<=9;i++)
        {
            if(i<=k)
            {
                k-=i;
                ds.add(i);
                ans.addAll(fun(i+1, n, k, ds));
                k+=i;
                ds.remove(ds.size() - 1);
            }
        }

        return ans;

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> ds = new ArrayList<>();
        return fun(1, k, n, ds);
    }
}