package com.leetcode.studyplan.datastructures.c01arr.p350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 疑惑点  重复次数 出现问题
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] res = new int[list.size()];
        int index = 0;
        for (Integer num : list) {
            res[index++] = num;
        }
        //showArray(nums1);
        return res;
    }

    private static void showArray(int[] nums1) {
        for (int i : nums1) {
            System.out.println("i = " + i);
        }
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        Solution solution = new Solution();
        int[] intersect = solution.intersect(nums1, nums2);

        showArray(intersect);
    }
}
