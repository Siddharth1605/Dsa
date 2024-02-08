class Solution {
    public int strStr(String text, String pattern) {
        if (pattern.length() == 0) return 0; // Empty pattern matches at the beginning
        if (text.length() < pattern.length()) return -1;

        int[] lps = computeLPSArray(pattern);
        
        int i = 0, j = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    return i - j; // Pattern found
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1; // Pattern not found
    }

    private int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
