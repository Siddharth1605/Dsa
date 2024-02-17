class Solution {
    public int c(int[] arr, int[] p) {
        int n = arr.length;
        int m = p.length;
        
        int l = 0;
        int r = 0;
        
        int count = 0;
        int k = 0;
        while(r<n)
        {
            if(k<m && p[k] == 1)   //Increasing
            {
                if(r<n && arr[r] < arr[r+1])
                    k++;
                else
                {
                    l = r;
                    k = 0;
                }
            }
            else if(k<m && p[k] == 0) //Equal
            {
                if(r<n && arr[r] == arr[r+1])
                    k++;
                else
                {
                    l = r;
                    k = 0;
                }
            }
            else if(k<m && p[k] == -1) //Decreasing
            {
                if(r<n && arr[r] > arr[r+1])
                    k++;
                else
                {
                    l = r;
                    k = 0;
                }
            }
            
            if(r - l + 1 == m + 1 && k == m)
            {
                count++;
                k = 0;
                l = r + 1;
            }
            r++;
        }
        return count;
    }
    public static boolean f(int[] arr, int s, int e, int[] p)
    {
        for(int i=0;i<p.length;i++)
        {
            if(p[i] == 0)
            {
                if(arr[s] != arr[s+1])
                    return false;
            }
            else if(p[i] == 1)
            {
                if(!(arr[s] < arr[s+1]))
                    return false;
            }
            else if(p[i] == -1)
            {
                if(!(arr[s] > arr[s+1]))
                    return false;
            }
            s++;
        }
        return true;
    }
    public int countMatchingSubarrays(int[] arr, int[] p) {
        int m = p.length;
        int n = arr.length;
        int cnt = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(i+m < n && f(arr, i, i+m, p))
                cnt++;
            else
                System.out.println(i);
        }
        return cnt;
    }

}
