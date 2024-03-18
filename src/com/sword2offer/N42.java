package com.sword2offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JUN
 */
public class N42 {
    public static void main(String[] args) {
        N42 n = new N42();
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));
        System.out.println(counter.ping(900));
        System.out.println(counter.ping(2000));
        System.out.println(counter.ping(3000));
        System.out.println(counter.ping(4000));
    }
}

class RecentCounter {
    private int windowSize;
    private Queue<Integer> times;

    public RecentCounter() {
        this.times = new LinkedList<>();
        this.windowSize = 3000;
    }

    public int ping(int t) {
        times.add(t);
        while (times.element() < t - windowSize) {
            times.remove();
        }
        return times.size();
    }
}