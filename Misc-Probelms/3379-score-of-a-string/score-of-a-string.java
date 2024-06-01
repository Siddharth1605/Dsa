class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        int n = s.length();
        int i = 1;
        while(i<n)
        {
            sum += Math.abs((int)s.charAt(i-1) - (int)s.charAt(i));
            i++;
        }
        return sum;
    }
}