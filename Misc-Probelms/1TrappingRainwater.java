class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int lmax = arr[0];
        int rmax = arr[n-1];
        for(int i=0;i<n;i++)
        {
            lmax = Math.max(arr[i], lmax);
            left[i] = lmax;

            rmax = Math.max(arr[n-i-1], rmax);
            right[n-i-1] = rmax;
        }

        int sum = 0;
        for(int i=0;i<n;i++)    
            sum += Math.min(left[i], right[i]) - arr[i];
        
        return sum;
    }
}