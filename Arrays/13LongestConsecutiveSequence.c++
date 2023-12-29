class Solution {
public:
   int longestConsecutive(vector < int > & nums) {
  int l = 0;
    unordered_set<int> hashset;
    int c=0;
    for(int i=0;i<nums.size();i++)    hashset.insert(nums[i]);
    
    for(auto it:hashset)
    {
      int x = it;
        if(hashset.find(x-1) == hashset.end()) //No smaller consecutive eleemnt
        {
          c=1;
          while(hashset.find(x+1) != hashset.end())
          {
            x++;
            c++;
          }
        }
        l = max(l,c);
    }
  return l;}
};