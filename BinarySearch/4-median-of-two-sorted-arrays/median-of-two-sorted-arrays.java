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