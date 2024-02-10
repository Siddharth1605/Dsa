class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        return fun(s, t);
    }
    public static boolean fun(String s, String t)
    {
        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            mp1.put(s.charAt(i), mp1.getOrDefault(s.charAt(i), 0) + 1);
            mp2.put(t.charAt(i), mp2.getOrDefault(t.charAt(i), 0) + 1);
        }

        if(mp1.size() != mp2.size())
            return false;
        
        //Map checking
        for(Map.Entry<Character, Integer> entry : mp1.entrySet())
        {
            char c = entry.getKey();
            int d = entry.getValue();

            if(!mp2.containsKey(c) || d != mp2.get(c))
                return false;
        }

        return true;
    }
}