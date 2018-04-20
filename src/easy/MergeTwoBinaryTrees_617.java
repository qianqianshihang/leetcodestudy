package easy;

/*
*
*
* Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:
Input:
	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
Output:
Merged tree:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7
* */
public class MergeTwoBinaryTrees_617 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode child1 = new TreeNode(3);
        child1.left = new TreeNode(5);
        treeNode1.left = child1;
        treeNode1.right = new TreeNode(2);

        TreeNode treeNode2 = new TreeNode(2);
        TreeNode child2 = new TreeNode(1);
        child2.right = new TreeNode(4);
        treeNode2.left = child2;

        TreeNode child3 = new TreeNode(3);
        child3.right = new TreeNode(7);
        treeNode2.right = child3;

        long start = System.nanoTime();
        TreeNode treeNode = mergeTrees(treeNode1, treeNode2);

        long end = System.nanoTime();
        System.out.println("time = " + (end - start) + "\n,result=" + treeNode);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode targetTree = new TreeNode(0);
        return mergeTreesHandle(targetTree, t1, t2);
    }

    public static TreeNode mergeTreesHandle(TreeNode targetTree, TreeNode t1, TreeNode t2) {
        targetTree.val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        if ((t1 != null && t1.left != null) || (t2 != null && t2.left != null)) {
            targetTree.left = new TreeNode(0);
            mergeTreesHandle(targetTree.left, t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        }
        if ((t1 != null && t1.right != null) || (t2 != null && t2.right != null)) {
            targetTree.right = new TreeNode(0);
            mergeTreesHandle(targetTree.right, t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        }
        return targetTree;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "val=" + val + (left != null ? ",\nleft=" + left.toString() : "") + (right != null ? ",\nright=" + right.toString() : "" + "\n");
        }
    }
}
