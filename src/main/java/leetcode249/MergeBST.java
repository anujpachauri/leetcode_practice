package leetcode249;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Anuj Pachauri
 *
5:16:50 pm
05-Aug-2021
 */
public class MergeBST {

	public TreeNode canMerge(List<TreeNode> trees) {
		Map<Integer, TreeNode> map = new HashMap<>(); /* Value to root map */
		Set<TreeNode> set = new HashSet<>();
		Map<TreeNode, TreeNode> parent = new HashMap<>(); /* Track the parent node which modified current node */
		for (TreeNode root : trees)
			map.put(root.val, root);

		for (TreeNode root : trees) {
			/*
			 * If left node is present as root somewhere in list, replace the left node with
			 * root
			 */
			if (root.left != null && map.containsKey(root.left.val) && !set.contains(map.get(root.left.val))) {
				TreeNode node = parent.getOrDefault(root, null);
				/* Special case of child node trying to set its root as child node */
				if (node != map.get(root.left.val)) {
					root.left = map.get(root.left.val);
					parent.put(map.get(root.left.val), root);
					set.add(map.get(root.left.val));
				}
			}

			/*
			 * If right node is present as root somewhere in list, replace the right node
			 * with root
			 */
			if (root.right != null && map.containsKey(root.right.val) && !set.contains(map.get(root.right.val))) {
				TreeNode node = parent.getOrDefault(root, null);
				if (node != map.get(root.right.val)) {
					root.right = map.get(root.right.val);
					parent.put(map.get(root.right.val), root);
					set.add(map.get(root.right.val));
				}
			}
		}

		/* There should be only one root */
		if (set.size() != trees.size() - 1)
			return null;

		/* Check if the new root is a valid BST */
		for (TreeNode root : trees) {
			if (!set.contains(root)) {
				if (validBST(root, null, null))
					return root;
				return null;
			}
		}

		return null;
	}

	private boolean validBST(TreeNode node, TreeNode left, TreeNode right) {
		if (node == null)
			return true;

		if (left != null && node.val <= left.val)
			return false;
		if (right != null && node.val >= right.val)
			return false;
		return validBST(node.left, left, node) && validBST(node.right, node, right);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
