package com.leetcode.stackqueue.p232;

import java.util.Stack;

/**
 * stack true
 * stack2 false
 */
public class MyQueue {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    /**
     * 当前队列 和 当前栈顺序是否 一致 标志  ;默认为不一致
     */
    private Boolean orderFlag = false;

    public MyQueue() { }

    /**
     * 判断顺序是否正确
     * @param x
     */
    public void push(int x) {
        //如果一致，先变不一致
        if (orderFlag){
            this.peek();
        }

        if (stack.empty() && stack2.empty()){
            stack.push(x);
        }else if (!stack.empty()){
            stack.push(x);
        }else if (!stack2.empty()){
            stack2.push(x);
        }
    }

    /**
     * 顺序便哈
     * @return
     */
    public int pop() {
        Integer pop = 0;
        if (orderFlag){
            if (stack2.isEmpty()){
                pop = stack.pop();
            }else{
                pop = stack2.pop();
            }

        }else {
            if (stack2.isEmpty()){
                while (!stack.isEmpty()){
                    stack2.push(stack.pop());
                }
                pop = stack2.pop();
            }else{
                while (!stack2.isEmpty()){
                    stack.push(stack2.pop());
                }
                pop = stack.pop();
            }

            orderFlag= !orderFlag;
        }

        return pop;
    }

    /**
     * 顺序变化
     * @return
     */
    public int peek() {
        Integer peek = 0;
        if (orderFlag){
            if (stack2.isEmpty()){
                peek = stack.peek();
            }else{
                peek = stack2.peek();
            }
        }else{
            if (stack2.isEmpty()){
                while (!stack.isEmpty()){
                    stack2.push(stack.pop());
                }
                peek = stack2.peek();
            }else{
                while (!stack2.isEmpty()){
                    stack.push(stack2.pop());
                }
                peek = stack.pop();
            }

            orderFlag= !orderFlag;
        }

        return peek;
    }

    public boolean empty() {
        return stack.isEmpty() && stack2.isEmpty();
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        int peek = myQueue.peek();
        System.out.println("peek = " + peek);
        int pop = myQueue.pop();
        System.out.println("pop = " + pop);

        System.out.println("myQueue = " + myQueue.peek());
        boolean empty = myQueue.empty();
        System.out.println("empty = " + empty);
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */