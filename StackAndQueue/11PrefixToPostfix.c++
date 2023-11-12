#include<bits/stdc++.h>
int prec(char c)
{
	if(c == '^')	return 3;
	else if(c == '/' || c=='*')	return 2;
	else if(c=='+' || c=='-')	return 1;
	else return -1;
}
string infixtopost(string s){
	// Write your code here
	stack<char> st;
	string result;

	for(int i=0;i<s.length();i++)
	{
		char c = s[i];
		if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'))
			result+=c;
		else if(c == '(')	st.push(c);
		else if(c == ')')
		{
			while(st.top()!='(')
			{
				result+=st.top();
				st.pop();
			}
			st.pop();
		}
		else
		{
			while(!st.empty() && prec(c) <= prec(st.top()))
			{
				result+=st.top();
				st.pop();
			}
			st.push(c);
		}

	}
		while(!st.empty())
		{
			result+=st.top();
			st.pop();
		}

		return result;

}
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
string prefixToInfixConversion(string s){
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
string preToPost(string s) {
    // Write Your Code Here
    string b = prefixToInfixConversion(s);
    string a = infixtopost(b);
    return a;
}