package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 */
public class _0438FindAllAnagramsInAString {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.findAnagrams("cbaebabacd", "abc"));
  }
}

class Solution {

  public List<Integer> findAnagrams(String s, String p) {
    int[] count = new int[128];
    for (char c : p.toCharArray()) {
      count[c]++;
    }

    List<Integer> result = new ArrayList<>();
    int required = p.length();
    for (int l = 0, r = 0; r < s.length(); ++r) {
      if (--count[s.charAt(r)] >= 0) {
        required--;
      }

      while (required == 0) {
        if ((r - l + 1) == p.length()) {
          result.add(l);
        }

        if (++count[s.charAt(l++)] > 0) {
          required++;
        }
      }
    }

    return result;
  }
}
