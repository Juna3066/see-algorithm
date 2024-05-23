package com.sword2offer;

import java.util.TreeSet;

/**
 * @author JUN
 */
public class N57 {
    /**
     * question 一个整数数组nums,是否存在两个元素，下标差的绝对值<=k，且下标对应的值，差的绝对值<=t
     */
    public static void main(String[] args) {
        test();
        N57 n = new N57();
        int[] nums = {1, 2, 3, 1};
        boolean b = n.containsNearByAlmostDuplicate(nums, 3, 0);
        System.out.println(b);
    }

    /**
     * java基于红黑树实现的，完全平衡的二叉查找树，TreeSet/Map 不同点一个存一个元素，一个存键值对。
     * treeSet的元素不能重复，treeMap的键不能重复
     */
    private static void test() {
        TreeSet<Integer> set = new TreeSet<>();
        int[] nums = {1, 1, 3, 2};
        for (int num : nums) {
            boolean opt = set.add(num);
            System.out.println("opt = " + opt);
        }
        System.out.println("set = " + set);
    }

    /*
     * keypoint 找到nums[cur]前k个元中，大于nums[cur]的最小值，小于nums[cur]的最大值，判断差值是否<=t即可。
     * 所以保存k个元素的TreeMap容器，且最后一个是下标为i的数组nums[i]
     * i>k,nums[i-k]是移除的那个
     *
     * 符合treemap的使用场景-完全平衡的二叉查找树。
     *      查找near的元素,
     */
    public boolean containsNearByAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = set.floor(nums[i]);
            if (floor != null && nums[i] - floor <= t) {
                return true;
            }
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && ceiling - nums[i] <= t) {
                return true;
            }
            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}
