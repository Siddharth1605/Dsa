class Solution {
    public boolean searchMatrix(int[][] arr, int t) {
        boolean ans = false;
        int m = arr[0].length;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i][0] <=t && arr[i][m-1]>=t)
                ans = ans || find(arr[i], t);
        }
        return ans;
    }
    public static boolean find(int[] arr, int t)
    {
        int s = 0;
        int e = arr.length - 1;
        while(s <= e)
        {
            int m = s + (e - s)/2;
            if(arr[m] == t)
                return true;
            else if(arr[m] < t)
                s = m + 1;
            else
                e = m - 1;
        }
        return false;
    }
}