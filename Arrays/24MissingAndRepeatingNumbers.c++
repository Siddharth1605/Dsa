vector<int> findMissingRepeatingNumbers(vector<int> a) {
    // Write your code here
  int n = a.size();
  long sf = n*(n+1)/2;
  long sf2 = n*(n+1)*(2*n + 1)/6;
  long s = 0;
  long s2 = 0;
  for(int i=0;i<n;i++)
  {
      s+=a[i];
      s2+=(a[i]*a[i]);
  }

  long var1 = s - sf;
  long var2 = s2 - sf2;
  var2=var2/var1;
  long x = (var1+var2)/2;
  long y = (var2-var1)/2;
  vector<int> ans={x,y};
  return ans;


}