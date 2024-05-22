import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        fun(s, ans, 0, s.length(), path);
        return ans;
    }

    private void fun(String s, List<List<String>> ans, int ind, int n, List<String> path) {
        if (ind == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = ind; i < n; i++) {
            if (palindrome(s, ind, i)) {
                path.add(s.substring(ind, i + 1));
                fun(s, ans, i + 1, n, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean palindrome(String s, int st, int e) {
        while (st <= e) {
            if (s.charAt(st) != s.charAt(e)) return false;
            st++;
            e--;
        }
        return true;
    }

}
