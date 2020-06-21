package cn.guoting.leetcode;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/two-sum/description/
 * <p>
 * 两数之和
 * </p>
 */
public class HomeWork03 {

  public static void main(String[] args) {

  }

  /**
   * 方法一: 暴力
   * <p>
   * 时间复杂度:o(n2)
   * </p>
   */
  public static int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return null;
    }

    for (int i = 0; i < nums.length - 1; i++) {
      int num1 = nums[i];
      int num2 = target - num1;
      for (int j = i + 1; j < nums.length; j++) {
        if (num2 == nums[j]) {
          return new int[]{i, j};
        }
      }
    }
    return null;
  }

  /**
   * 方法二: 哈希表
   * </p>
   * 两次迭代
   */
  public static int[] twoSum2(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return null;
    }
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      hashMap.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      int num1 = nums[i];
      int num2 = target - num1;
      Integer num2Index = hashMap.get(num2);
      if (num2Index != null && num2Index != i) {
        return new int[]{i, num2Index};
      }
    }
    return null;
  }

  /**
   * 方法二: 哈希表
   * </p>
   * 一次迭代
   */
  public static int[] twoSum3(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return null;
    }
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int num1 = nums[i];
      int num2 = target - num1;
      Integer num2Index = hashMap.get(num2);
      if (num2Index != null) {
        return new int[]{num2Index, i};
      }
      hashMap.put(num1, i);
    }
    return null;
  }
}
