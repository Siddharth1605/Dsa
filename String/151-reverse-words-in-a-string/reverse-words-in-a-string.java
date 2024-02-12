class Solution {
    public String reverseWords(String s) {
        int i = 0;
        int n = s.length();
        int k = n - 1;

        //O(N)
        while(s.charAt(i) == ' ')
            i++;
        while(s.charAt(k) == ' ')
            k--;
        boolean flag = true;
        String a = "";
        while(i<=k)
        {
            char c = s.charAt(i);
            if(!(c == ' '))
                flag = true;
            if(flag)
                a += c;
            if(c == ' ')
                flag = false;
            i++;
        }

        //O(N)
        return rev(a.toCharArray());
    }
    public static void r(char[] arr, int s, int e)
    {
        while(s <= e)
        {
            char t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;
            s++;
            e--;
        }
    }
    public static String rev(char[] arr)
    {
        r(arr,0,arr.length - 1);
        int s = 0;
        int e = 0;
        while(e < arr.length)
        {
            if(arr[e] == ' ')
            {
                r(arr, s, e-1);
                s = e + 1;
            }   
            e++;
        }
        r(arr, s, e-1);
        return new String(arr);
    }
}