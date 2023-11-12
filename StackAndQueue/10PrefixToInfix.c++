string postfixtoInfix(string s) {
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
string prefixToInfixConversion(string &s){
	// Write your code here.
	string a = s;
	reverse(a.begin(), a.end());
	string b = postfixtoInfix(a);
	reverse(b.begin(), b.end());
	for(int i=0;i<b.length();i++)
	{
		if(b[i] == '(')	b[i] = ')';
		else if(b[i] == ')')	b[i] = '(';
	}
	return b;
	
}
