package com.sword2offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JUN
 */
public class N87 {
    public static void main(String[] args) {
        N87 n = new N87();
        String str = "10203040";
        List<String> res = n.restoreIP(str);
        System.out.println("res = " + res);
    }

    private List<String> restoreIP(String str) {
        List<String> res = new ArrayList<>();
        helper(str, 0, 0, "", "", res);
        return res;
    }

    /*
     * keypoint
     * 如果str遍历完，且有4个段，且最后一个段是合法的，就能组成一个合法的ip，添加到结果集。
     * 否则剪枝，i合法下标，segI合法下标的情况，
     * 获取当前字符，判断方当前seg后，能否组成合法段，能的话，缩小问题。
     * 不能的话，
     * 老段，长度不能是0，且，段索引小于最后一个
     * 当前字符，形成新段，ip+老段+"."组合。
     */
    private void helper(String str, int i, int segi, String seg, String ip, List<String> res) {
        if (i == str.length() && segi == 3 && isSeg(seg)) {
            //数组遍历完，段也达到4个，并且最后一个合法段，添加ip
            res.add(ip + seg);
        } else if (i < str.length() && segi <= 3) {
            char c = str.charAt(i);
            if (isSeg(seg + c)) {
                //选项1 当前段，和，当前字符，能组成，有效的段。
                helper(str, i + 1, segi, seg + c, ip, res);
            }
            if (seg.length() > 0 && segi < 3) {
                //选项2 开启新段
                helper(str, i + 1, segi + 1, "" + c, ip + seg + ".", res);
            }
        }
    }

    /*
     * keypoint ip地址有 3个点和4个seg组成， 例如： seg.seg.seg.seg 如何判断seg是否合法？
     * str表示的seg段
     *  【1】是0
     * 或
     *  【2】1-255且不能以0开头
     *
     */
    private boolean isSeg(String s) {
        return s.equals("0") || (s.charAt(0) != '0' && 1 <= Integer.parseInt(s) && Integer.parseInt(s) <= 255);
    }

}
