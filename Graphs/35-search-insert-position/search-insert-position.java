class Solution {
    public int searchInsert(int[] arr, int t) {
        int l = 0;
        int n = arr.length;
        int h = n-1;
        int ans = -1;
        while(l<=h) {
            int m = l + (h-l)/2;
            if(arr[m] == t)
                return m;
            if(arr[m] > t){
                ans = m;
                h = m-1;
            }
            else 
                l = m+1;
        }
        return ans == -1 ? n : ans;
    
    }
}