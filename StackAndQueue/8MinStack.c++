class MinStack {
  stack < long long > st;
  long long mini= INT_MAX;
  public:
    /** initialize your data structure here. */
    MinStack() {
      
    }

  void push(int value) {
    long long val = value;
    if (st.empty()) {
      mini = val;
      st.push(val);
    } 
    else {
      if (val < mini) {
        st.push(2 *val - mini);
        mini = val;
      } 
      else {
        st.push(val);
      }
    }
  }

  void pop() {

    if (st.top() < mini) {
      mini = 2 * mini - st.top();
    }

    st.pop();
  }

  int top() {

    if (st.top() < mini) return mini;
    return st.top();
  }

  int getMin() {
    return mini;
  }
};