class Solution {
    public static Set<String> count(String x, String input, int freq[])
    {
        Set<String> st = new HashSet<>();
        if(x.length() >= 1)
            st.add(x);
        
        for(int i=0;i<input.length();i++)
        {
            if(freq[i] == 0)
            {
                freq[i] = 1;
                st.addAll(count(x+input.charAt(i), input, freq));
                freq[i] = 0;
            }
        }

        return st;
    }
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[tiles.length()];
        Arrays.fill(freq, 0);
        return count("", tiles, freq).size();
    }
}