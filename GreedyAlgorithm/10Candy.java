class Solution {
    public int candy(int[] arr) {
        int n = arr.length;
        int[] lt = new int[n];
        Arrays.fill(lt, 1);
        for(int i=1;i<n;i++)
        {
            if(arr[i] > arr[i-1])
                lt[i] = 1 + lt[i-1];
        }

        int c = 0;
        for(int i=n-2;i>=0;i--)
        {
            if(arr[i] > arr[i+1])
                lt[i] = Math.max(lt[i] , 1 + lt[i+1]);
            c+=lt[i];
        }
        c+=lt[n-1];
        return c;
    }
}