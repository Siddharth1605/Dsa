class Solution {
    public boolean lemonadeChange(int[] bills) {
        Stack<Integer> st5=new Stack();
        Stack<Integer> st10=new Stack();

        for(int i=0;i<bills.length;i++)
        {
            if(bills[i] == 5)
            {
                st5.push(5);
            }
            else if(bills[i] == 10)
            {
                st10.push(10);
                if(st5.empty())    return false;
                st5.pop();
            }
            else if(bills[i] == 20)
            {
                if(!st10.empty())
                {
                    st10.pop();
                    if(st5.empty())    return false;
                    st5.pop();
                }
                else
                {
                    for(int j=1;j<=3;j++)
                    {
                        if(st5.empty())    return false;
                        st5.pop();
                    }
                }
            }
        }
        return true;
    }
}