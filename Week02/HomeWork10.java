package cn.guoting.leetcode;

/**
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 * <p>
 * 剑指 Offer 49. 丑数
 * </p>
 * Created by Lei Guoting on 2020/6/20.
 */
public class HomeWork10 {

  public int nthUglyNumber(int n) {
    int index2 = 0, index3 = 0, index5 = 0;
    int result[] = new int[n];
    result[0] = 1;
    for (int i = 1; i < n; i++) {
      int ugly2 = result[index2] * 2;
      int ugly3 = result[index3] * 3;
      int ugly5 = result[index5] * 5;
      result[i] = Math.min(Math.min(ugly2, ugly3), ugly5);
      if (result[i] == ugly2) {
        index2++;
      }
      if (result[i] == ugly3) {
        index3++;
      }
      if (result[i] == ugly5) {
        index5++;
      }
    }
    return result[n - 1];
  }
}
