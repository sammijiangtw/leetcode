package org.example.sliding_window;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        int pSize = p.length();
        int sSize = s.length();

        if (pSize > sSize) {
            return result;
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < pSize; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sCount, pCount)) {
            result.add(0);
        }

        for (int i = 0; i < sSize - pSize; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pSize) - 'a']++;

            if (Arrays.equals(sCount, pCount)) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String s = "ababababab";
        String p = "aab";
        System.out.println("start");
        List<Integer> result = findAnagrams(s, p);
        System.out.println(JSON.toJSONString(result));
    }
}
