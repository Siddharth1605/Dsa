class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for(int i : nums) {
            count += operations(i);
        }
        return count;
    }
    public static int operations(int x) {
        int rem = x % 3;
        return Math.min(1, rem);
    }
}