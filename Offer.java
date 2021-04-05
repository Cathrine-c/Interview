package java_1101.java;

import java.util.Stack;

public class Offer {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
      stack1.push(node);
    }

    public int pop() {
       if (stack2.size()==0) {
           while (!stack1.isEmpty()) {
               Integer ret = stack1.peek();
               stack2.push(ret);
               stack1.pop();
           }
       }
       int res=stack2.peek();
       stack2.pop();
       return res;
       }


    public int minNumberInRotateArray(int [] array) {
        return 0;
    }


}
