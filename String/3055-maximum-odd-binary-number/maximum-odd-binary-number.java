class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int ones = 0;
        int zeroes = 0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i) == '1')
                ones++;
            else
                zeroes++;
        }

        char[] arr = new char[n];
        for(int i=0;i<ones - 1;i++)
            arr[i] = '1';
        for(int i=ones - 1;i<n-1;i++)
            arr[i] = '0';
        arr[n-1] = '1';
        return new String(arr);
    }
}