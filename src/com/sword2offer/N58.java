package com.sword2offer;

import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap 类似TreeSet 不通点，是键值对
 *
 * @author JUN
 */
public class N58 {
    /**
     * question 设计数据结构-日程表
     */
    public static void main(String[] args) {
        N58 n = new N58();
        MyCalendar calendar = new MyCalendar();
        //左闭右开
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(15, 25));
        System.out.println(calendar.book(20, 30));
    }
}


class MyCalendar {
    TreeMap<Integer, Integer> events;

    public MyCalendar() {
        this.events = new TreeMap<>();
    }

    /*
     * keypoint [start,end)表示的区域，不重叠，可以插入；
     *
     *  选择合适的数据结构，用来优化时间效率，空间换时间
     *
     * 思路
     * 判断重叠，
     * 1.查找start的preStart的preEnd>start,不能插入。
     * 2.查找start的postStart，end>postStart，不能插入
     *
     * 其他的情况，可以插入
     *
     * 需要查找，查找
     * 区间存储，选择数据结构：
     * 排序后的，动态数组ArrayList，查找O(logn),插入O(n)
     * 平衡的二叉查找树，查找O(logn), 一次缩小一遍
     *
     * java提供了 平衡的二叉查找树，TreeMap,TreeSet
     *
     */
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> event = events.floorEntry(start);
        if (event != null && event.getValue() > start) {
            return false;
        }
        event = events.ceilingEntry(end);
        if (event != null && end > event.getKey()) {
            return false;
        }
        events.put(start, end);
        return true;
    }

}