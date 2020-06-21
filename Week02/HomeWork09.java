package cn.guoting.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * <p>
 * 429. N叉树的层序遍历
 * </p>
 */
public class HomeWork09 {

  /**
   * 方法一: 队列
   */
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> resultList = new ArrayList<>();
    if (root != null) {
      LinkedList<Node> queue1 = new LinkedList<>();
      queue1.offerLast(root);
      while (!queue1.isEmpty()) {
        List<Integer> valueList = new ArrayList<>();
        LinkedList<Node> queue2 = new LinkedList<>();
        while (!queue1.isEmpty()) {
          Node node1 = queue1.pollFirst();
          valueList.add(node1.val);
          if (node1.children != null) {
            queue2.addAll(node1.children);
          }
        }
        resultList.add(valueList);
        queue1 = queue2;
      }
    }
    return resultList;
  }

  class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  ;
}
