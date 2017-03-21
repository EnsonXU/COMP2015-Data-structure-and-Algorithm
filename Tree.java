
public class Tree {

	TreeNode root = null;
	String result = null;
	boolean first = true;

	public Tree() {
	}

	public String preorder() {
		result = " ";
		preorder(root);
		return result;
	}

	public void preorder(TreeNode n) {
		if (n == null) {
			return;
		} else {
			result = result + n.s + " ";
			preorder(n.left);
			preorder(n.right);
		}
	}

	public TreeNode buildAVL(String s) {
		String nodes[] = s.split(" ");
		root = null;
		for (int i = 0; i < nodes.length; i++) {
			insert(nodes[i]);
		}
		return root;
	}

	public void insert(String v) {
		root = insert(root, v);
	}

	TreeNode insert(TreeNode n, String v) {
		if (n == null) {
			n = new TreeNode(v);
			return n;
		}

		if (v.compareTo(n.s) < 0) {
			n.left = insert(n.left, v);
			n = balance(n);
		} else if (v.compareTo(n.s) >= 0) {
			n.right = insert(n.right, v);
			n = balance(n);
		}
		n.height = updateHeight(n);
		return n;
	}

	public void delete(String v) {
		root = delete(root, v);
	}

	private TreeNode delete(TreeNode n, String v) {
		if (n == null) {
			return null;
		}
		if (v.compareTo(n.s) < 0) {
			n.left = delete(n.left, v);
			balance(n);
		} else if (v.compareTo(n.s) > 0) {
			n.right = delete(n.right, v);
			balance(n);
		} else if (n.s.equals(v)) {
			if (n.left != null && n.right != null) {
				n.s = findMin(n.right).s;
				n.right = delete(n.right, n.s);
			} else if (n.left == null) {
				n = n.right;
			} else if (n.right == null) {
				n = n.left;
			}
		}
		return n;
	}

	private TreeNode findMin(TreeNode n) {
		if (n == null) {
			return null;
		} else if (n.left == null) {
			return n;
		} else {
			return findMin(n.left);
		}
	}

	private int updateHeight(TreeNode n) {
		if (n == null)
			return -1;

		n.height = Math.max(updateHeight(n.left), updateHeight(n.right)) + 1;
		return n.height;

	}

	public int updateHeight() {
		return updateHeight(root);
	}

	String identifyCase(TreeNode n) {
		int delta = Math.abs(updateHeight(n.left) - updateHeight(n.right));

		if (delta > 1) {
			if (updateHeight(n.left) > updateHeight(n.right)) {
				if (updateHeight(n.left.left) < updateHeight(n.left.right))
					return "lr";
				else
					return "ll";

			} else {
				if (updateHeight(n.right.left) > updateHeight(n.right.right))
					return "rl";
				else
					return "rr";
			}
		} else
			return "";
	}

	TreeNode rotateClockwise(TreeNode a) {
		TreeNode b, x;
		b = a.left;
		x = b.right;

		// exchange positions
		a.left = x;
		b.right = a;
		return b;
	}

	TreeNode rotateCounterClockwise(TreeNode a) {
		TreeNode b, x;
		b = a.right;
		x = b.left;

		a.right = x;
		b.left = a;
		return b;
	}

	TreeNode balance(TreeNode n) {
		if (n != null) {
			n.height = updateHeight(n);

			switch (identifyCase(n)) {
			case "ll":
				n = rotateClockwise(n);
				n.height = updateHeight(n);
				break;
			case "rr":
				n = rotateCounterClockwise(n);
				n.height = updateHeight(n);
				break;
			case "lr":
				n.left = rotateCounterClockwise(n.left);
				n = rotateClockwise(n);
				n.height = updateHeight(n);
				break;
			case "rl":
				n.right = rotateClockwise(n.right);
				n = rotateCounterClockwise(n);
				n.height = updateHeight(n);
				break;
			}
		}
		return n;
	}

}
