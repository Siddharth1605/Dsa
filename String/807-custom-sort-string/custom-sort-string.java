class Solution {
    public String customSortString(String order, String s) {    
        int o = order.length();
        int n = s.length();

        StringBuilder[] arr = new StringBuilder[o + 1];
        StringBuilder notin = new StringBuilder();
        
        int[] position = new int[27];
        Arrays.fill(position, 0);
        int c = 1;
        for(int i=0;i<o;i++)
        {
            position[order.charAt(i) - 'a' + 1] = c;
            c++;
        }
        int k = 0;
        for(int i=0;i<n;i++)
        {
            if(position[s.charAt(i) - 'a' + 1] == 0)
                notin.append(s.charAt(i));
            else
            {
                int pos = position[s.charAt(i) - 'a' + 1];
                if(arr[pos] == null)
                    arr[pos] = new StringBuilder();
                arr[pos].append(s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<=o;i++)
            if(arr[i] != null)
                ans.append(arr[i]);
        ans.append(notin);
        

        //Tc : O(4*n)
        //Sc : O(3*n)
        return new String(ans);
    }
}