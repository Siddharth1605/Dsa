public class Solution {
    public static int calculateMinPatforms(int arr[], int dep[], int n) {
        // Write your code here.
    int ans = 1;
    int c = 1;
    for(int i=0;i<n;i++)
    {
            c = 1;
        for(int j=0;j<n;j++)
        {
            if(i!=j)
                if(arr[i] >= arr[j] && arr[i]<=dep[j])
                    c++;
            
        }
            ans = Math.max(ans, c);
    }
    return ans;
}

}