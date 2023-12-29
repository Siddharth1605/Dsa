class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& arr) {
       int n = arr.size();
       vector<vector<int>> ans;
       sort(arr.begin(), arr.end());
       for(int i=0;i<n;i++)
       {
           if(i>0 && arr[i] == arr[i-1])    {continue;}
           int j = i+1;
           int k = n-1;
           while(j<k)
           {
               int sum = arr[i] + arr[j] + arr[k];
               if(sum == 0)
               {
                   vector<int> temp={arr[i],arr[j],arr[k]};
                   ans.push_back(temp);
                   j++;
                   k--;
                   while(arr[j]==arr[j-1] && j<k)  j++;
                   while(arr[k]==arr[k+1] && j<k)  k--;
               }
               else if(sum < 0)   j++;
               else if(sum > 0)k--;
           }
           
       }
       return ans;
    }
};