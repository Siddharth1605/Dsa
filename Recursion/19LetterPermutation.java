class Solution {
    public static List<String> fun(int i, String result)
    {
        List<String> ans = new ArrayList<>();;
        if(i == result.length())
        {
            ans.add(result);
            return ans;
        }

        if(result.charAt(i)>='0' && result.charAt(i)<='9')
            return fun(i+1,result);
        
        String modify = convertCase(result, i);

        List<String> notpick = fun(i+1, result);
        List<String> pick = fun(i+1, modify);

        ans.addAll(notpick);
        ans.addAll(pick);

        return ans;

    }
    public List<String> letterCasePermutation(String s) {
        return fun(0, s);
    }
    public static String convertCase(String result, int ind)
    {
        char[] arr = result.toCharArray();

        for(int i=0;i<result.length();i++)
        {
            if(i == ind)
            {
                if(Character.isLowerCase(arr[i]))
                    arr[i] = Character.toUpperCase(arr[i]);
                else if(Character.isUpperCase(arr[i]))
                    arr[i] = Character.toLowerCase(arr[i]);
            }
        }

        return new String(arr);
    }
}