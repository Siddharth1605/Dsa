class Solution {
    public int search(int[] arr, int t) {
         int n = arr.length;
        int l = 0;
        int h = n-1;
        while(l<h) {
            int m = l + (h-l)/2;
            if(arr[m] == t)
                return m;
            if(arr[m] == arr[l] && arr[m] == arr[h]) {
                l++;
                h--;
            }
            else if(arr[l] <= arr[m]) {
                if(arr[m] >= t && arr[l] <= t) {
                    h = m-1;
                } else {
                    l = m+1;
                } 
            } else {
                 if(arr[m] <= t && arr[h] >= t) {
                    l = m+1;
                } else {
                    h = m-1;
                }
            }
        }
        return arr[l] == t ? l : -1;
    }
}