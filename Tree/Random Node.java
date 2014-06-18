//Get random node in binary tree without extra space

import java.util.LinkedList;
import java.util.Random;


public class RandomNode {
	public static TreeNode getNode(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return root;
		}
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		TreeNode selected = root;
		nodes.add(root);
		int count = 1;
		Random random = new Random();
		while (!nodes.isEmpty()) {
			TreeNode node = nodes.remove();
			int num = random.nextInt(count);
			if (num == 0) {
				selected = node;
			}
			if (node.left != null) {
				nodes.add(node.left);
			}
			if (node.right != null) {
				nodes.add(node.right);
			}
			count++;		
		}
		return selected;
	}
}
