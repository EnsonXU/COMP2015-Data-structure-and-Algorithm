
public class TreeNode {
	public String s;
	public TreeNode left, right;
	public int height; // the height of this subtree

	TreeNode(String s) {
		this.s = s;
		left = right = null;
		height = 0;
	}
}
