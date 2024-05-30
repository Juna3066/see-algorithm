package com.sword2offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个正整数集合(数组)，元素不重复。
 * 给一个target值
 * <p>
 * 找出符合条件的组合，组合中一个数组可出现任意多次。
 *
 * @author JUN
 */
public class N81 {
    /**
     * question 面试题81：给定，不重复元素的，正整数数组，和一个和target。返回所有和是target的集合（元素可重复选择）
     */
    public static void main(String[] args) {
        N81 n = new N81();
        List<List<Integer>> lists = n.combinationSum(new int[]{2, 3, 4, 5}, 10);
        lists.stream().forEach(e -> System.out.println(e));
    }

    /*
     * keypoint 元素可重复，用代码如何表示？递归函数的参数定义，步骤思路
     */
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, target, 0, new LinkedList<Integer>(), result);
        return result;
    }

    private void helper(int[] nums, int target, int i, LinkedList<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<>(combination));
        } else if (target > 0 && i < nums.length) {
            //本步骤不添加数字，先跳过不操作，进行下一步操作
            helper(nums, target, i + 1, combination, result);
            //下一步操作完，本步骤，再加入自身，做不跳过处理
            combination.add(nums[i]);
            // keypoint 当前数字添加到集合，剩余目标值是，当前元素继续添加到集合
            helper(nums, target - nums[i], i, combination, result);
            //回溯到前一步，移除自身的影响
            combination.removeLast();
        }
    }
}
