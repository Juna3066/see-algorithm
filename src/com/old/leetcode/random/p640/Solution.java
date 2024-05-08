package com.old.leetcode.random.p640;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {


    private void demoTest1(String left) {
        String[] ls = left.split("-|\\+");
        for (String l : ls) {
            System.out.println(l);
        }
    }


    public static void main(String[] args) {
//        String str = "equation = \"100x+5-3+x=6+x+296+50x\"";
        String str = "x+5-3+x=6+x-2";
        String s = new Solution().solveEquation(str);
        System.out.println(s);
    }

    public String solveEquation(String equation) {
        //String s = equation.split("\"")[1];
        String[] split = equation.split("=");
        String left = split[0];
        String right = split[1];

        ArrayList<String> leftXs = new ArrayList<>();
        ArrayList<String> rightNs = new ArrayList<>();
        eqMove(leftXs,rightNs,left,true);
        eqMove(leftXs,rightNs,right,false);

        int preSNum = 0;
        //[0-9] \d
        String pattern = "[0-9]";
        Pattern c = Pattern.compile(pattern);

        for (String str : leftXs) {
            String repX = c.matcher(str).find() ? "" : "1";
            String x = str.replace("x", repX);
            preSNum = preSNum + Integer.valueOf(x);
        }

        int sum = 0;
        for (String rightN : rightNs) {
            sum += Integer.parseInt(rightN);
        }

        String res = "";
        if (preSNum==0){
            if(sum==0){
                res="Infinite solutions";
            }else{
                res="No solution";
            }
        }else{
            res="x="+(sum/preSNum);
        }

        return res;
    }

    private void eqMove(List<String> leftXs,List<String> rightNs, String arr,Boolean isX ) {
        /**
         *
         * ？ 零或者1
         * * 零或者多
         * + 一次或者多次
         */
        String pattern = "(-|\\+)?(([0-9]*x{1})|([0-9]+))";
        Pattern c = Pattern.compile(pattern);
        Matcher matcher = c.matcher(arr);
        while (matcher.find()){
            String group = matcher.group();
            if (isX){
                if (group.contains("x")){
                    leftXs.add(group);
                }else {
                    rightNs.add(getXFNumStr(group));
                }
            }else{
                if (group.contains("x")){
                    leftXs.add(getXFNumStr(group));
                }else {
                    rightNs.add(group);
                }
            }
        }
    }

    public String getXFNumStr(String numStr){
        String res;
        if (numStr.contains("-")){
            res = numStr.replace("-", "+");
        }else if (numStr.contains("+")){
            res = numStr.replace("+", "-");
        }else{
            res = "-" + numStr;
        }
        return res;
    }
}
