class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            Map<Character, Integer> mp = new HashMap<>();
            for(int j=i;j<n;j++)
            {
                mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
                int x = get(mp);
                sum += x;
            }
        }
        return sum;
    }
    public static int get(Map<Character, Integer> mp)
    {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(Map.Entry<Character, Integer> entry : mp.entrySet())
        {
            mini = Math.min(mini, entry.getValue());
            maxi = Math.max(maxi, entry.getValue());
        }
        return maxi - mini;
    }
}