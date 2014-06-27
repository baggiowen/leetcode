import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Serialization {
	public static int index = 0;
	
	public static void serialize(TreeNode root, BufferedWriter writer) throws IOException {
		if (root == null) {
			writer.write("# ");
			return;
		}
		writer.write(String.valueOf(root.val) + " ");
		serialize(root.left, writer);
		serialize(root.right, writer);
	}
	
	public static TreeNode deserialize(BufferedReader reader) throws IOException {
		String[] tokens = reader.readLine().trim().split(" ");
		return helper(tokens);
	}
	
	public static TreeNode helper(String[] tokens) {
		if (tokens[index].equals("#")) {
			index++;
			return null;
		}
		TreeNode node = new TreeNode(Integer.parseInt(tokens[index]));
		index++;
		node.left = helper(tokens);
		node.right = helper(tokens);
		return node;
	}
	
	public static void main(String[] args) throws IOException {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		
		File file = new File("test.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		serialize(node1, writer);
		writer.close();
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		TreeNode root = deserialize(reader);
		reader.close();
		System.out.print(root.val);
	}
}
