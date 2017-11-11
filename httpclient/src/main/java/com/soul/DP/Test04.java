package com.soul.DP;

public class Test04 {

    public static int countWaysDP(int n) {
        int[] map = new int[n + 1];
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        return countWaysDP(n, map);
    }

    private static int countWaysDP(int n, int[] map) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (map[n] > -1) {
            return map[n];
        } else {
            map[n] = countWaysDP(n - 1, map)
                    + countWaysDP(n - 2, map)
                    + countWaysDP(n - 3, map);
            return map[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(countWaysDP(5)); // 13
        // 11111, 1112, 1121, 1211, 122, 131, 113, 23, 221, 2111, 212, 32, 311
    }

}