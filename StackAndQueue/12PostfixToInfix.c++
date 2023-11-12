string postToInfix(string s) {
    // Write your code here.
    stack<string> st;
	for(int i=0;i<s.length();i++)
	{
		char c = s[i];
		if((c>='a' && c<='z') || (c>='A' && c<='Z'))
		{
			string op = "";
			op+=c;
			st.push(op);
		}
		else
		{
			string op1 = st.top();
			st.pop();
			string op2 = st.top();
			st.pop();
			string x = "("+op2+c+op1+")";
			st.push(x);
		}
	}
	return st.top();
}