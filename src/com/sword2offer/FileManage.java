package com.sword2offer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author JUN
 */
public class FileManage {

    // 已经会的题目
    private static List<Integer> okList = Arrays.asList(
            36, 37, 38
    );

    public static void main(String[] args) {
        String originFile = "D:\\CodeAll\\Code\\see-leetcode\\src\\com\\sword2offer\\N0.java";
        String regex = "N\\d{1,3}";
        for (int i = 1; i < 120; i++) {
            if (!okList.contains(i)) {
                createFileAndContent(originFile, "N" + i, regex);
                //deleteFile(originFile, regex, "N" + i);
            }
        }
    }

    private static void deleteFile(String originFile, String regex, String goalFileName) {
        File goalFile = new File(originFile.replaceFirst(regex, goalFileName));
        goalFile.delete();
    }

    private static void createFileAndContent(String originFile, String goalFileName, String regex) {
        //replaceAll方法
        String goalFile = originFile.replaceAll(regex, goalFileName);
        try (FileOutputStream fos = new FileOutputStream(goalFile);
             FileInputStream fis = new FileInputStream(originFile)
        ) {
            byte[] bytes = new byte[1024];
            int read = 0;
            while ((read = fis.read(bytes)) != -1) {
                fos.write(new String(bytes, 0, read).replaceAll(regex, goalFileName).getBytes());
            }
        } catch (IOException e) {
            //throw new RuntimeException(e);
        }
    }
}
