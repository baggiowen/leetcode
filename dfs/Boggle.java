import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class Boggle {
	public static List<String> solve(char[][] grid, HashSet<String> dict) {
		List<String> res = new LinkedList<String>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				helper(res, grid, i, j, "", dict);
			}
		}
		return res;
	}
	
	public static void helper(List<String> res, char[][] grid, int i, int j, String word, HashSet<String> dict) {
		char c = grid[i][j];
		word = word + c;
		if (word.length() >= 3) {
			if (dict.contains(word)) {
				res.add(word);
			}
		}
		
		//top-left
		if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] != '.') {
			grid[i][j] = '.';
			helper(res, grid, i - 1, j - 1, word, dict);
			grid[i][j] = c;
		}
		
		//top		
		if (i - 1 >= 0 && grid[i - 1][j] != '.') {
			grid[i][j] = '.';
			helper(res, grid, i - 1, j, word, dict);
			grid[i][j] = c;
		}
		
		//top-right
		if (i - 1 >= 0 && j + 1 < grid[0].length && grid[i - 1][j + 1] != '.') {
			grid[i][j] = '.';
			helper(res, grid, i - 1, j + 1, word, dict);
			grid[i][j] = c;
		}
		
		//right
		if (j + 1 < grid[0].length && grid[i][j + 1] != '.') {
			grid[i][j] = '.';
			helper(res, grid, i, j + 1, word, dict);
			grid[i][j] = c;
		}
		
		//bottom-right
		if (i + 1 < grid.length && j + 1 < grid[0].length && grid[i + 1][j + 1] != '.') {
			grid[i][j] = '.';
			helper(res, grid, i + 1, j + 1, word, dict);
			grid[i][j] = c;
		}
		
		//bottom
		if (i + 1 < grid.length && grid[i + 1][j] != '.') {
			grid[i][j] = '.';
			helper(res, grid, i + 1, j, word, dict);
			grid[i][j] = c;
		}
		
		//bottom-left
		if (i + 1 < grid.length && j - 1 >= 0 && grid[i + 1][j - 1] != '.') {
			grid[i][j] = '.';
			helper(res, grid, i + 1, j - 1, word, dict);
			grid[i][j] = c;
		}
		
		//left
		if (j - 1 >= 0 && grid[i][j - 1] != '.') {
			grid[i][j] = '.';
			helper(res, grid, i, j - 1, word, dict);
			grid[i][j] = c;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		char[][] grid = new char[][]{{'a', 's', 'i'}, {'d', 'e', 'm'}, {'o', 'n', 't'}};
		HashSet<String> dict = new HashSet<String>();
		BufferedReader br = new BufferedReader(new FileReader("/Users/gaohong/Documents/workspace/Sorting/scowl-7.1/final/english-words.50"));
		String line;
		while ((line = br.readLine()) != null) {
			dict.add(line.trim());
		}
		List<String> res = solve(grid, dict);
		System.out.print(res.toString());
		
	}
}
