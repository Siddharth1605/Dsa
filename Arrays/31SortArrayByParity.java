class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while(i<j)
        {
            if(arr[i]%2 == 1  && arr[j]%2==0)
            {
                arr[i] = arr[i] + arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i] - arr[j];

                i++;
                j--;
            }
            else if(arr[i]%2 == 1)
                j--;
            else if(arr[j]%2 == 0)
                i++;
            else 
            {
                i++;
                j--;
            }
        }
        return arr;
    }
}