/*
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Better Approach Tc:O(n)
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int i2 = n/2;
        int i1 = i2 - 1;
        int i1e1 = 0;
        int i2e2 = 0;
        int cnt = 0;
        int i=0;
        int j=0;
        while(i<n1 && j<n2)
        {
            if(nums1[i] <= nums2[j])
            {
                if(cnt == i1)
                    i1e1 = nums1[i];
                if(cnt == i2)
                    i2e2 = nums1[i];
                cnt++;
                i++;
            }
            else 
            {
                if(cnt == i1)
                    i1e1 = nums2[j];
                if(cnt == i2)
                    i2e2 = nums2[j];
                cnt++;
                j++;
            }
        }

        while(i<n1)
        {
            if(cnt == i1)
                i1e1 = nums1[i];
            if(cnt == i2)
                i2e2 = nums1[i];
            cnt++;
            i++;
        }
        while(j<n2)
        {
                if(cnt == i1)
                    i1e1 = nums2[j];
                if(cnt == i2)
                    i2e2 = nums2[j];
                cnt++;
                j++;
        }
        if(n%2 == 1)
            return i2e2;
        return (double)((double)(i1e1 + i2e2)) / 2.0;
    }
}
*/
//Optimized solution O(log(min(n1, n2)))
class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        if(arr1.length > arr2.length)
            return median(arr2, arr1);
        return median(arr1, arr2);
    }
    public static double median(int[] arr1, int[] arr2)
    {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int left = (n1 + n2 + 1)/2;
        int low = 0;
        int high = n1;
         while(low <= high)
        {
            int mid1 = low + (high - low)/2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1 < n1)
                r1 = arr1[mid1];
            if(mid2 < n2)
                r2 = arr2[mid2];
            if(mid1 >= 1)
                l1 = arr1[mid1 - 1];
            if(mid2 >= 1)
                l2 = arr2[mid2 - 1];
            if(l1<=r2 && l2<=r1)
            {
                if((n1+n2)%2 == 1)
                    return Math.max(l1, l2);
                return ((double)(Math.max(l1, l2) + Math.min(r1, r2)))/2.0;
            }
            else if(l1 > r2)
                high = mid1 - 1;
            else if(l2 > r1)
                low = mid1 + 1;
        }
        return 0;
    }
}