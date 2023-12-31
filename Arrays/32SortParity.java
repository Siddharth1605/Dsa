class Solution {
    public int[] brute(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int o=1;
        int e=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]%2 == 0)
            {
                ans[e] = arr[i];
                e += 2;
            }
            else
            {
                ans[o] = arr[i];
                o += 2;
            }
        }

        return ans;
    }
    public int[] sortArrayByParityII(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n-1;
        while(i<n)
        {
            if(arr[i]%2 == 0)
                i+=2;
            else if(arr[j]%2==1)
                j+=2;
            else
            {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        return arr;
    }
}