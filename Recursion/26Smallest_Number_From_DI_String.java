import java.util.Arrays;

class Solution {
    public static String fun(int ind, String ans, String pat, int[] freq, String answer) {
        if (ind == pat.length()) {
            if (answer.isEmpty())
                answer = ans;

            return answer;
        }

        for (int i = 1; i <= 9; i++) {
            if (pat.charAt(ind) == 'I') {
                if (freq[i - 1] == 0 && ans.charAt(ans.length() - 1) < i + '0') {
                    freq[i - 1] = 1;
                    answer = fun(ind + 1, ans + Integer.toString(i), pat, freq, answer);
                    freq[i - 1] = 0;
                }
            } 
            else if (pat.charAt(ind) == 'D') {
                if (freq[i - 1] == 0 && ans.charAt(ans.length() - 1) > i + '0') {
                    freq[i - 1] = 1;
                    answer = fun(ind + 1, ans + Integer.toString(i), pat, freq, answer);
                    freq[i - 1] = 0;
                }
            }
        }
        return answer;
    }

    public String smallestNumber(String pat) {
        int n = pat.length();
        int[] freq = new int[9];
        Arrays.fill(freq, 0);
        String answer = "";
        for (int i = 1; i <= 9; i++) {
            freq[i-1]=1;
            answer = fun(0, Integer.toString(i), pat, freq, answer);
            freq[i-1]=0;
        }

        return answer;
    }
}
