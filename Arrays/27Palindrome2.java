class Solution {
    public static boolean ispal(String s, int i, int j)
    {
        while(i<j)
        {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        int c = 1;
        while(i<j)
        {
            if(s.charAt(i) != s.charAt(j))
                return ispal(s, i+1, j) || ispal(s, i, j-1);
            i++;
            j--;
        }
        return true;
    }
}