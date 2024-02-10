 class Solution {
    public boolean rotateString(String s, String goal) {
        return fun(s, goal);
    }

    public static boolean fun(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        s += s;
        int i = 0;
        int j = 0;
        int n = s.length();
        int m = goal.length();
        while (i < n) {
            if (s.charAt(i) == goal.charAt(j)) {
                i++;
                j++;
                if (j == m)
                    return true;
            } else {
                if (j != 0) {
                    // Reset j only if it's not the first character mismatch
                    i = i - j + 1;
                    j = 0;
                } else {
                    i++;
                }
            }
        }
        return false;
    }
}
