package com.whz.springmvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * map比list快
 */
public class MainTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            // testList();
             testMap();
        }
    }

    private static void testList() {
        long startTime = System.nanoTime();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        for (String str : list) {
            if ("a".equals(str)) {
                System.out.println(System.nanoTime() - startTime);
                return;
            }
        }
    }

    private static void testMap() {
        long startTime = System.nanoTime();
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");

        for (String str : map.values()) {
            if ("a".equals(str)) {
                System.out.println(System.nanoTime() - startTime);
                return;
            }
        }
    }
}
