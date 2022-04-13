package com.leetcode.random.p640;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public String solveEquation(String equation) {
        String s = equation.split("\"")[1];
        String[] split = s.split("=");
        String left = split[0];
        String right = split[1];

        System.out.println("right = " + right);
        System.out.println("left = " + left);

        //demoTest2(left);
        //demoTest1(left);



        ArrayList<String> leftXs = new ArrayList<>();
        ArrayList<String> rightNs = new ArrayList<>();
        demoTest2(leftXs,rightNs,left,true);
        demoTest2(leftXs,rightNs,right,false);

        for (String str : leftXs) {
            System.out.print(str);
        }
        System.out.print(" = " );
//        for (String str : rightNs) {
//            System.out.print(str);
//        }

        int sum = 0;
        for (String rightN : rightNs) {
            sum += Integer.parseInt(rightN);
        }
        System.out.print(sum);

        return null;
    }

    private void demoTest2(List<String> leftXs,List<String> rightNs, String arr,Boolean isX ) {
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
            System.out.println(group);
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

        System.out.println("");
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

    private void demoTest1(String left) {
        String[] ls = left.split("-|\\+");
        for (String l : ls) {
            System.out.println(l);
        }
    }

    public static void main(String[] args) {
        String str = "equation = \"100x+5-3+x=6+x-2\"";
        new Solution().solveEquation(str);
    }
}
