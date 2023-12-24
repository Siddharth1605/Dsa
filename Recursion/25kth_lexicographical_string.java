class Solution {
    public static void fun(int prev, int n, String str, List<String> ds, int k)
    {
        if(str.length() == n)
        {
            ds.add(str);
            return;
        }

        
        if(ds.size() == k)
            return;

        for(int i=97;i<100;i++)
        {
            if(i != prev)
            {
                char c = (char) i;
                fun(i, n, str+c, ds, k);
            }
        }
    }
    public String getHappyString(int n, int k) {
        List<String> ds = new ArrayList<>();
        String str = "";
        
        fun(-1, n, str, ds, k);

        if(ds.size() < k)
            return "";
        return ds.get(k - 1);
    }
}