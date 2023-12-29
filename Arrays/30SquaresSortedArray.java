class Solution {
    public int[] sortedSquares(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int j = n-1;
        int i = 0;
        int k = n-1;
        while(i<=j)
        {
            if(Math.abs(arr[i]) > Math.abs(arr[j]))
            {
                ans[k] = arr[i] * arr[i];
                i++;
            }
            else
            {
                ans[k] = arr[j] * arr[j];
                j--;
            }
            k--;
        }

        return ans;
    }
}