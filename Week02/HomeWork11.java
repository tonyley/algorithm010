package cn.guoting.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * <p>
 * 347. 前 K 个高频元素
 * </p>
 * Created by Lei Guoting on 2020/6/20.
 */
public class HomeWork11 {

  public int[] topKFrequent(int[] nums, int k) {
    if (nums == null || k > nums.length) {
      return new int[0];
    }

    HashMap<Integer, Integer> hashMap = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      Integer count = hashMap.get(num);
      if (count == null) {
        count = 0;
      }
      hashMap.put(num, ++count);
    }
    PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue(
        new Comparator<Map.Entry<Integer, Integer>>() {
          @Override
          public int compare(Map.Entry<Integer, Integer> left,
              Map.Entry<Integer, Integer> right) {
            return right.getValue() - left.getValue();
          }
        });
    Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
    while (iterator.hasNext()) {
      heap.offer(iterator.next());
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = heap.poll().getKey();
    }
    return result;
  }
}
