class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int r = 0;
        int l = 0;
        int sum = 0;
        int ans = 0;
        while(r<n)
        {
            sum += Math.abs(t.charAt(r) - s.charAt(r));
            while(sum > maxCost)
            {
                sum -= Math.abs(t.charAt(l) - s.charAt(l));
                l++;
            }
            ans = Math.max(r - l + 1, ans);
            r++;
        }
        return ans;
    }
}