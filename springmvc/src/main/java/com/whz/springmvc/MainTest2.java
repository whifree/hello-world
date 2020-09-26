package com.whz.springmvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTest2 {
    static String cmmdtyCode = "000000000000";

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long startMemory = runtime.freeMemory();
        Map<String, Map<String, List<String>>> dataBaseMap = new HashMap<>(2);
        Map<String, List<String>> dataBase1Map = new HashMap<>(500);
        for (int i = 0; i < 500; i++) {
            makeCmmdtyCode(dataBase1Map, i);
        }

        Map<String, List<String>> dataBase2Map = new HashMap<>(500);
        for (int i = 500; i < 1000; i++) {
            // database2
            makeCmmdtyCode(dataBase2Map, i);
        }

        dataBaseMap.put("dataBase1", dataBase1Map);
        dataBaseMap.put("dataBase2", dataBase2Map);
        long endMemory = runtime.freeMemory();
        System.out.println(dataBaseMap);
        System.out.println("消耗：" + (startMemory - endMemory) / (1024 * 1024));
    }

    private static void makeCmmdtyCode(Map<String, List<String>> dataBaseMap, int i) {
        List<String> cmmdtyCodes = new ArrayList<>(1000);
        dataBaseMap.put(String.valueOf(i), cmmdtyCodes);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 500; j++) {
            String _cmmdtyCode = sb.append(String.format("%03d", j)).append(cmmdtyCode).append(String.format("%03d", i)).toString();
            cmmdtyCodes.add(_cmmdtyCode);
            sb.setLength(0);
        }
    }
}
