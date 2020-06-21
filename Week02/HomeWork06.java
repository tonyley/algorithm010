package cn.guoting.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 * </p>
 * https://leetcode-cn.com/problems/group-anagrams/
 * </p>
 * <code>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * </p>
 * 输出: [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
 * </code>
 */
public class HomeWork06 {

  /**
   * 方法一: 排序数组分类
   */
  public static List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
      return new ArrayList<>();
    }

    Map<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      String str = strs[i];
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String newStr = new String(chars);
      List<String> list = map.get(newStr);
      if (list == null) {
        list = new ArrayList<>();
        map.put(newStr, list);
      }
      list.add(str);
    }

    List<List<String>> groupList = new ArrayList<>();
    for (List<String> list : map.values()) {
      groupList.add(list);
    }
    return groupList;
  }

  /**
   * 方法一: 统计字符串中字符个数
   */
  public static List<List<String>> groupAnagrams2(String[] strs) {
    if (strs == null || strs.length == 0) {
      return new ArrayList<>();
    }

    Map<String, List<String>> map = new HashMap<>();
    int[] acsii = new int[26];
    StringBuilder hashKeyBuilder = new StringBuilder();
    for (int i = 0; i < strs.length; i++) {
      String str = strs[i];
      int length = str.length();
      Arrays.fill(acsii, 0);
      for (int j = 0; j < length; j++) {
        acsii[str.charAt(j) - 'a']++;
      }
      hashKeyBuilder.setLength(0);
      for (int j = 0; j < acsii.length; j++) {
        hashKeyBuilder.append(acsii[j]);
      }
      String hashKey = hashKeyBuilder.toString();
      List<String> list = map.get(hashKey);
      if (list == null) {
        list = new ArrayList<>();
        map.put(hashKey, list);
      }
      list.add(str);
    }
    List<List<String>> groupList = new ArrayList<>();
    for (List<String> list : map.values()) {
      groupList.add(list);
    }
    return groupList;
  }
}
