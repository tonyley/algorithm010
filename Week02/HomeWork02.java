package cn.guoting.week01;

/**
 * https://leetcode-cn.com/problems/valid-anagram/submissions/
 * <p>
 * 242. 有效的字母异位词
 * </p>
 */
public class HomeWork02 {

  public static void main(String[] args) {
    isAnagram3("a", "b");
  }

  /**
   * 方法一：排序法
   * </p>
   * 时间复杂度: O(nlogn)
   */
  public static boolean isAnagram(String s, String t) {
    char[] leftChars = s.toCharArray();
    char[] rightChars = t.toCharArray();
    Arrays.sort(leftChars);
    Arrays.sort(rightChars);
    return Arrays.equals(leftChars, rightChars);
  }

  /**
   * 方法二：哈希表
   * </p>
   * 两个字符串同时加，减统计次数
   */
  public static boolean isAnagram2(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
      counter[s.charAt(i) - 'a']++;
      counter[t.charAt(i) - 'a']--;
    }

    for (int i = 0; i < counter.length; i++) {
      if (counter[i] != 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * 方法三：哈希表
   * </p>
   * 第一个字符串先加，统计字符出现的次数 然后，对第二个字符串做字符次数相减
   */
  public static boolean isAnagram3(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
      counter[s.charAt(i) - 'a']++;
    }

    for (int i = 0; i < t.length(); i++) {
      int position = t.charAt(i) - 'a';
      counter[position]--;
      if (counter[position] < 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * 方法三：哈希表
   * </p>
   * 使用HashMap，可以广泛应用于unicode字符串
   */
  public static boolean isAnagram4(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    HashMap<Character, AtomicInteger> countMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char leftChar = s.charAt(i);
      char rightChar = t.charAt(i);
      AtomicInteger leftCount = countMap.get(leftChar);
      if (leftCount == null) {
        leftCount = new AtomicInteger(0);
        countMap.put(leftChar, leftCount);
      }
      leftCount.incrementAndGet();
      AtomicInteger rightCount = countMap.get(rightChar);
      if (rightCount == null) {
        rightCount = new AtomicInteger(0);
        countMap.put(rightChar, rightCount);
      }
      rightCount.decrementAndGet();
    }

    Iterator<AtomicInteger> countIterator = countMap.values().iterator();
    while (countIterator.hasNext()) {
      AtomicInteger count = countIterator.next();
      if (count.get() != 0) {
        return false;
      }
    }
    return true;
  }
}
