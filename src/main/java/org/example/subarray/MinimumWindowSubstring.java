package org.example.subarray;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        String result = "";
        if (t.length() > s.length()) {
            return result;
        }

        Map<Character, Integer> ori = new HashMap<>();
        Map<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character tc = t.charAt(i);
            ori.put(tc, ori.getOrDefault(tc, 0) + 1);

            Character sc = s.charAt(i);
            if (t.contains(sc + "")) {
                cnt.put(sc, cnt.getOrDefault(sc, 0) + 1);
            }
        }

        if (check(ori, cnt)) {
            if (t.length() == s.length()) {
                return s;
            } else {
                result = s.substring(0, t.length());
            }
        }

        int l = 0;
        for (int r = t.length(); r < s.length(); r++) {

            Character sc = s.charAt(r);
            if (ori.containsKey(sc)) {
                cnt.put(sc, cnt.getOrDefault(sc, 0) + 1);
            }

            while (check(ori, cnt) && l<=r) {

                String temp;
                if (r == s.length() - 1) {
                    temp = s.substring(l);
                } else {
                    temp = s.substring(l, r + 1);
                }

                if ("".equals(result)) {
                    result = temp;
                } else {
                    result = temp.length() > result.length() ? result : temp;
                }

                Character ss = s.charAt(l);
                if (cnt.containsKey(ss)) {
                    cnt.put(ss, cnt.get(ss) - 1);
                }

                l++;
            }
        }

        return result;
    }

    private static boolean check(Map<Character, Integer> ori, Map<Character, Integer> cnt) {

        if (ori.size() != cnt.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : cnt.entrySet()) {

            if (ori.get(entry.getKey()) > (entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

//        String s = "ADOBECODEBANC";
//        String t = "ABC";

        String s = "abc";
        String t = "cba";
        String result = minWindow(s, t);
        System.out.println(result);
    }
}
