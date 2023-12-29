class Solution {
    public static boolean isascii(char c)
    {
        if( (c>='a' && c<='z') || (c>='A' && c<='Z') )
            return true;
        return false;
    }
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i<j)
        {
            char a = arr[i];
            char b = arr[j];
            if(isascii(a) && isascii(b))
            {
                char t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
            else if(isascii(a))
                j--;
            else if(isascii(b))
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