class Solution {
    public static boolean isVowels(char c)
    {
        if(c == 'a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U')
            return true;
        return false;
    }
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] arr = s.toCharArray();
        while(i<j)
        {
            char a = arr[i];
            char b = arr[j];
            if(isVowels(a) && isVowels(b))
            {
                char t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
            else if(isVowels(a))
                j--;
            else if(isVowels(b))
                i++;
            else
            {
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}