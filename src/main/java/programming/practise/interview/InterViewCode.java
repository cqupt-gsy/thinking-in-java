package programming.practise.interview;

import java.util.ArrayList;
import java.util.List;

// 验证搜索二叉树
public class InterViewCode {

  public boolean isValidBST(TreeNode root) {

    if (root == null) return true;

    List<Integer> list = new ArrayList<>();
    inorder(root, list); // BST经过中序遍历 List中的元素是升序且不重复的.

    return isSorted(list);
  }

  private void inorder(TreeNode node, List<Integer> list) {
    if (node != null) {
      inorder(node.left, list);
      list.add(node.val);
      inorder(node.right, list);
    }
  }

  private boolean isSorted(List<Integer> list) {
    for (int i = 0; i < list.size() - 1; i++) {
      if (list.get(i) >= list.get(i + 1)) return false;
    }
    return true;
  }

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
  }
}
