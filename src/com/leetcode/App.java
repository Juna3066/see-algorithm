package com.leetcode;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;

public class App {
    private ArrayList<String> classNames = new ArrayList<>();

    private static final String SCAN_PACKAGE = "com.leetcode";

    /**
     * 递归扫描所有class文件
     * @param packageName
     */
    private void doScanner(String packageName) {
        //将所有的包路径转换为文件路径
        URL url = this.getClass().getClassLoader().getResource(packageName.replaceAll("\\.", "/"));
        File dir = new File(url.getFile());
        for (File file : dir.listFiles()) {
            //如果是文件夹，继续递归
            if(file.isDirectory()){
                doScanner(packageName + "." + file.getName());
            }else{
                if (file.getName().endsWith(".class")){
                    classNames.add(packageName + "." + file.getName().replace(".class", "").trim());
                }
            }
        }
    }

    @Test
    public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String problem = "217";
        String cName = "";
        doScanner(SCAN_PACKAGE);
        //classNames.forEach(System.out::println);
        for (String className : classNames) {
            if (className.contains(problem)){
                cName = className;
                break;
            }
        }
        Class<?> clazz = Class.forName(cName);
        Object o = clazz.newInstance();

        Method[] methods = clazz.getMethods();
        Object invoke = methods[0].invoke(o, new int[]{1, 2, 3, 4});
        System.out.println("invoke = " + invoke);

//        Method solute = clazz.gbetMethod("solute", null);
//        if (solute!=null){
//            solute.invoke(o);
//        }


    }

}
