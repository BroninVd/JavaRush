package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File dir = new File(root);
        ArrayList<String> strings = new ArrayList<>();
        ArrayDeque<File> files = new ArrayDeque<>();

        if (dir.isDirectory()){

            for (File file : dir.listFiles()) {
                files.addLast(file);
            }

            while (!files.isEmpty()){
                File file = files.pollFirst();
                if (file.isDirectory()) {
                    for (File file1 : file.listFiles()){
                        files.addLast(file1);
                    }
                } else {
                    strings.add(file.getAbsolutePath());
                }
            }
        }

        return strings;

    }

    public static void main(String[] args) {
        
    }
}
