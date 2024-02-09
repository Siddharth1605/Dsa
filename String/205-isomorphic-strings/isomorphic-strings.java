class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character, Character> mp1 = new HashMap<>();
        Map<Character, Character> mp2 = new HashMap<>();

        int n = s.length();
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            char d = t.charAt(i);
            if((mp1.containsKey(c) && mp1.get(c) != d) || (mp2.containsKey(d) && mp2.get(d) != c))
                return false;
            mp1.put(c, d);
            mp2.put(d, c);
        }
        return true;
    }
}