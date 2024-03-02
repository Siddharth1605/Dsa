class Solution {
    public static int climb(int[] arr, int i, int[] memo)
    {
        if(i < 0)
            return 0;
        if(i == 0 || i == 1)
            return arr[i];
        if(memo[i] != -1)
            return memo[i];
        int l = climb(arr, i-1, memo) + arr[i];
        int r = climb(arr, i-2, memo) + arr[i];
        return memo[i] = Math.min(l, r);
    }
    public int minCostClimbingStairs(int[] arr) {
        int n = arr.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        memo[0] = arr[0];
        memo[1] = arr[1];
        for(int i=2;i<n;i++)
        {
            int l = arr[i] + memo[i-1];
            int r = arr[i] + memo[i-2];
            memo[i] = Math.min(l, r);
        }
        //int zero = climb(arr, n-1, memo);
        //int one = climb(arr, n-2, memo);
        return Math.min(memo[n-1], memo[n-2]);
    }
}