package cn.guoting.leetcode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * <p>
 * 26. 删除排序数组中的重复项
 * </p>
 * Created by Lei Guoting on 2020/6/21.
 */
public class HomeWork03 {

  /**
   * 方法一: 双指针法
   */
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }
}
