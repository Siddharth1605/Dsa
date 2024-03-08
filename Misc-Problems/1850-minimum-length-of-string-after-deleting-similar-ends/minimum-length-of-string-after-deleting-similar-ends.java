class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;
        if(i == j)
            return 1;
        while(i<n && j>=0 && s.charAt(i) == s.charAt(j))
        {
            char c = s.charAt(i);
            while(i<n  && s.charAt(i) == c)
                i++;
            while(j>=0 && s.charAt(j) == c)
                j--;
            if(i > j)
                return 0;
            if(i == j)
                return 1;
        }
        if(j - i == 0)
            return 0;
        else
            return j - i + 1;

    }
}