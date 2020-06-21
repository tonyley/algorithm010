package cn.guoting.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 * <p>
 * N叉树的前序遍历
 * </p>
 */
public class HomeWork04 {

  /**
   * 方法一: 递归
   */
  public List<Integer> preorder(Node root) {
    List<Integer> resultList = new ArrayList<>();
    if (root != null) {
      preorder(root, resultList);
    }
    return resultList;
  }

  private void preorder(Node node, List<Integer> values) {
    values.add(node.val);
    if (node.children != null && !node.children.isEmpty()) {
      for (Node child : node.children) {
        preorder(child, values);
      }
    }
  }

  /**
   * 方法二：迭代，使用栈
   */
  public List<Integer> preorder2(Node root) {
    List<Integer> resultList = new ArrayList<>();
    if (root != null) {
      LinkedList<Node> stack = new LinkedList<>();
      LinkedList<Node> queue = new LinkedList<>();
      stack.offerFirst(root);
      Node node;
      while ((node = stack.pollFirst()) != null) {
        resultList.add(node.val);
        if (node.children != null && !node.children.isEmpty()) {
          for (Node child : node.children) {
            queue.offerLast(child);
          }
          Node child;
          while ((child = queue.pollLast()) != null) {
            stack.offerFirst(child);
          }
        }
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
}
