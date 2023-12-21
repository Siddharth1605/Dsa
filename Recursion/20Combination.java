class Solution {
    public static List<List<Integer>> fun(int i, int n, int k, List<Integer> ds)
    {
        List<List<Integer>> ans = new ArrayList<>();
        if(ds.size() == k)
        {
            ans.add(new ArrayList<>(ds));
            return ans;
        }
        if(i>n)
            return ans;
        
        ds.add(i);
        List<List<Integer>> pick = fun(i+1, n, k, ds);
        ds.remove(ds.size() - 1);
        
        List<List<Integer>> npick = fun(i+1, n, k, ds);

        ans.addAll(pick);
        ans.addAll(npick);

        return ans;
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> ds = new ArrayList<>();
        return fun(1, n, k, ds);
    }
}