class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i<n1 && j<n2)
        {
            if(nums1[i] == nums2[j])
            {
                ans.add(nums1[i]);
                int x = nums1[i];
                while(i<n1 && nums1[i] == x)
                    i++;
                while(j<n2 && nums2[j] == x)
                    j++;
            }
            else if(nums1[i] < nums2[j])
                i++;
            else if(nums1[i] > nums2[j])
                j++;
        }
        int[] arr = new int[ans.size()];
        for(int k=0;k<ans.size();k++)
            arr[k] = ans.get(k);
        return arr;
    }
}