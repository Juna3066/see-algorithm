package com.sword2offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JUN
 */
public class N41 {
    private static void test() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        Integer peek = queue.peek();
        System.out.println("peek = " + peek);
        Integer poll = queue.poll();
        System.out.println("poll = " + poll);
        Integer poll2 = queue.poll();
        System.out.println("poll2 = " + poll2);
    }

    public static void main(String[] args) {
        //test();
        N41 n = new N41();
        MovingAverage average = new MovingAverage(3);
        System.out.println(average.next(1));
        System.out.println(average.next(2));
        System.out.println(average.next(3));
        System.out.println(average.next(4));
        System.out.println(average.next(5));
    }
}

class MovingAverage {
    private Queue<Integer> queue;
    private double sum;
    private int size;

    public MovingAverage(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
    }

    /**
     * 定义和 = 旧和 + 尾进的 - 头出的  （超容量的情况）
     * 然后求平均值
     *
     * @param val
     * @return
     */
    public double next(int val) {
        sum += val;
        queue.add(val);
        if (queue.size() > this.size) {
            sum -= queue.remove();
        }
        return sum / queue.size();
    }

}
