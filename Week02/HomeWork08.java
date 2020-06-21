package cn.guoting.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * <p>
 * 144. 二叉树的前序遍历
 * </p>
 */
public class HomeWork08 {

  /**
   * 方法一: 递归
   */
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> valueList = new ArrayList<>();
    preorderTraversal(root, valueList);
    return valueList;
  }

  public void preorderTraversal(TreeNode node, List<Integer> valueList) {
    if (node != null) {
      valueList.add(node.val);
      preorderTraversal(node.left, valueList);
      preorderTraversal(node.right, valueList);
    }
  }

  /**
   * 方法二：迭代
   */
  public List<Integer> preorderTraversal2(TreeNode root) {
    List<Integer> valueList = new ArrayList<>();
    if (root != null) {
      LinkedList<TreeNode> stack = new LinkedList<>();
      TreeNode node = root;
      while (node != null || !stack.isEmpty()) {
        valueList.add(node.val);
        if (node.right != null) {
          stack.offerFirst(node.right);
        }
        node = node.left;
        if (node == null) {
          node = stack.pollFirst();
        }
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
