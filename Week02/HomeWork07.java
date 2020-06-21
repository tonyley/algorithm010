package cn.guoting.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * <p>
 * 94 二叉树的中序遍历
 * </p>
 */
public class HomeWork07 {

  /**
   * 方法一: 递归
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> valueList = new ArrayList<>();
    inorderTraversal(root, valueList);
    return valueList;
  }

  private void inorderTraversal(TreeNode node, List<Integer> valueList) {
    if (node != null) {
      inorderTraversal(node.left, valueList);
      valueList.add(node.val);
      inorderTraversal(node.right, valueList);
    }
  }


  /**
   * 方法二: 迭代
   */
  public List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> valueList = new ArrayList<>();
    if (root != null) {
      LinkedList<TreeNode> stack = new LinkedList();
      TreeNode node = root;
      while (node != null || !stack.isEmpty()) {
        while (node != null) {
          stack.offerFirst(node);
          node = node.left;
        }
        node = stack.pollFirst();
        valueList.add(node.val);
        node = node.right;
      }
    }
    return valueList;
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
