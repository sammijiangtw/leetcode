package org.example.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {

        if (s.length() <= 1) {
            return s.length();
        }

        String[] chars = s.split("");

        int max = 1;
        int l = 0;
        int r = 0;
        Set<String> set = new HashSet<>();

        while (l < s.length() - 1) {

            if(l != 0){
                set.remove(chars[l-1]);
            }else{
                set.add(chars[l]);
            }

            while (r + 1 < s.length() && !set.contains(chars[r + 1])) {
                set.add(chars[r + 1]);
                r++;
            }

            max = Math.max(max, r-l+1);
            l++;
        }

        return max;
    }

    public static int lengthOfLongestSubstringLame(String s) {

        if (s.length() <= 1) {
            return s.length();
        }

        String[] chars = s.split("");

        int l = 0;
        int max = 1;
        while (l < s.length() - 1) {

            int r = l;
            Set<String> set = new HashSet<>();

            if (l == r) {
                r++;
                if (chars[l].equals(chars[r])) {
                    l++;
                    continue;
                } else {
                    set.add(chars[l]);
                    set.add(chars[r]);
                }
            }

            while (r + 1 < s.length() && !set.contains(chars[r + 1])) {
                set.add(chars[r + 1]);
                r++;
            }

            max = Math.max(max, r - l + 1);
            l++;
        }
        return max;
    }

    public static void main(String[] args) {

//        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "anviaj";
        String s = "pwwkew";
        System.out.println("start");
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
