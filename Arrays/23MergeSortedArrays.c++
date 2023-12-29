class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int i = m - 1;
        int j=0;
        while(i>=0 && j<n)
        {
            if(nums1[i]>nums2[j])    
            {
                int t = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = t;

                  i--;
            j++;

            }
            else break;
        }
        sort(nums1.begin(), nums1.begin()+m);
        sort(nums2.begin(), nums2.end());

        for(int i=m,j=0;i<m+n;i++,j++)
        {
            nums1[i] = nums2[j];
        }
    }
};