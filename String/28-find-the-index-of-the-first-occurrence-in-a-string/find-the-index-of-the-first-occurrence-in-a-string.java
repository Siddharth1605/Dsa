class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        int[] lps = compute(needle);
        int i = 0;
        int j = 0;
        int m = needle.length();
        int n = haystack.length();

        while(i < n)
        {
            if(haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
            }
            else if(j == 0)
            {
                i++;
            }
            else
                j = lps[j-1];
            if(j == m)
                return i - j;
        }
        return -1;
    }
    public static int[] compute(String needle)
    {
        int prevlps = 0;
        int i = 1;
        int[] lps = new int[needle.length()];
        lps[0] = 0;
        while(i < needle.length())
        {
            if(needle.charAt(i) == needle.charAt(prevlps))
            {
                lps[i] = prevlps + 1;
                prevlps++;
                i++;
            }
            else if(prevlps == 0)
            {
                i++;
            }   
            else
            {
                prevlps = lps[prevlps - 1];
            }
        }
        return lps;
    }
}