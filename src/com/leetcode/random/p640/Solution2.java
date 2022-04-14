package com.leetcode.random.p640;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution2 {
    public String solveEquation(String equation) {
        String res = "";
        int preSNum = 0;
        int sum = 0;
        boolean afEq = false;

        String p = "=|[-\\+]|(([0-9]*x{1})|([0-9]+))";
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(equation);

        String pattern2 = "[0-9]";
        Pattern c = Pattern.compile(pattern2);

        while (matcher.find()){
            String group = matcher.group();
            if ("+".equals(group)){
                matcher.find();
                String gn = matcher.group();
                if (gn.contains("x")){
                    int num = Integer.parseInt(gn.replace("x", c.matcher(gn).find() ? "" : "1"));
                    preSNum = afEq ?  (preSNum - num) : (preSNum + num);
                }else {
                    sum = afEq ?  (sum - Integer.parseInt(gn)) : (sum + Integer.parseInt(gn));
                }
            }else if("-".equals(group)){
                matcher.find();
                String gn = matcher.group();
                if (gn.contains("x")){
                    int num = Integer.parseInt(gn.replace("x", c.matcher(gn).find() ? "" : "1"));
                    preSNum = afEq ?  (preSNum + num) : (preSNum - num);
                }else {
                    sum = afEq ?  (sum + Integer.parseInt(gn)) : (sum - Integer.parseInt(gn));
                }
            } else if("=".equals(group)){
                afEq = true;
            }else{
                if (group.contains("x")){
                    int num = Integer.parseInt(group.replace("x", c.matcher(group).find() ? "" : "1"));
                    preSNum = afEq ?  (preSNum - num) : (preSNum + num);
                }else {
                    sum = afEq ?  (sum - Integer.parseInt(group)) : (sum + Integer.parseInt(group));
                }
            }
        }

        if (preSNum==0){
            if(sum==0){
                res="Infinite solutions";
            }else{
                res="No solution";
            }
        }else{
            res="x="+(sum/preSNum)*-1;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "10x+20=60";
        String s = new Solution2().solveEquation(str);
        System.out.println(s);
    }
}
