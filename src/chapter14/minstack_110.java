package chapter14;

import java.util.Stack;

/**
 * Created by Administrator on 2017/6/7.
 * 设计栈，使min、push、pop的时间复杂度都是O(1)
 * 需要一个新栈来存储最小值，使记录的最小值随着原有栈顶元素的变化而变化。
 * 当心元素来时，同时将当前最小值压入辅助栈
 * 辅助栈的栈顶一直是最小值，只要将新元素同它比较，取较小者作为当前新的最小值
 * 元素出栈时，辅助栈顶也出栈，求最小值时，只要看最小值即可
 */
public class minstack_110 {
    public static void main(String[] args){
        MinStack minStack=new MinStack();
        minStack.push(4);//4
        minStack.push(1);//14
        minStack.push(2);//114
        minStack.push(3);//1114
        System.out.print(minStack.min());//1  114
        minStack.pop();
        System.out.print(minStack.min());//1  14
        minStack.pop();
        System.out.print(minStack.min());//1   4
        minStack.pop();
        System.out.print(minStack.min());//4

    }
}

class MinStack{
    Stack<Integer> s;
    Stack<Integer> s2; //辅助栈
    MinStack(){
        s=new Stack<>();
        s2=new Stack<>();
    }
    public void push(int val){
        s.push(val);
        //同时向s2压入较小值
        if(s2.empty()||val<s2.peek())  s2.push(val);
        else s2.push(s2.peek());
    }
    public int min(){
        return s2.peek();
    }
    public int pop(){
        s2.pop();
        return s.pop();
    }
}
