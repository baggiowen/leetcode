//two methods: 1. with prefix 2. without prefix
//when the board is small: less or equal than 3 * 3, without prefix is a little bit better;
//when the board is large: more than 3 * 3, with prefix is much better


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class Boggle {
	public static List<String> solve(char[][] grid, HashSet<String> dict, HashSet<String> prefix) {
		List<String> res = new LinkedList<String>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				helper(res, grid, i, j, "", dict, prefix);
			}
		}
		return res;
	}
	
	public static void helper(List<String> res, char[][] grid, int i, int j, String word, HashSet<String> dict, HashSet<String> prefix) {
		char c = grid[i][j];
		word = word + c;
		if (word.length() >= 3) {
			if (dict.contains(word)) {
				res.add(word);
			}
		}
		
		//top-left
		if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] != '.' && prefix.contains(word + grid[i - 1][j - 1])) {
			grid[i][j] = '.';
			helper(res, grid, i - 1, j - 1, word, dict, prefix);
			grid[i][j] = c;
		}
		
		//top		
		if (i - 1 >= 0 && grid[i - 1][j] != '.' && prefix.contains(word + grid[i - 1][j])) {
			grid[i][j] = '.';
			helper(res, grid, i - 1, j, word, dict, prefix);
			grid[i][j] = c;
		}
		
		//top-right
		if (i - 1 >= 0 && j + 1 < grid[0].length && grid[i - 1][j + 1] != '.' && prefix.contains(word + grid[i - 1][j + 1])) {
			grid[i][j] = '.';
			helper(res, grid, i - 1, j + 1, word, dict, prefix);
			grid[i][j] = c;
		}
		
		//right
		if (j + 1 < grid[0].length && grid[i][j + 1] != '.' && prefix.contains(word + grid[i][j + 1])) {
			grid[i][j] = '.';
			helper(res, grid, i, j + 1, word, dict, prefix);
			grid[i][j] = c;
		}
		
		//bottom-right
		if (i + 1 < grid.length && j + 1 < grid[0].length && grid[i + 1][j + 1] != '.' && prefix.contains(word + grid[i + 1][j + 1])) {
			grid[i][j] = '.';
			helper(res, grid, i + 1, j + 1, word, dict, prefix);
			grid[i][j] = c;
		}
		
		//bottom
		if (i + 1 < grid.length && grid[i + 1][j] != '.' && prefix.contains(word + grid[i + 1][j])) {
			grid[i][j] = '.';
			helper(res, grid, i + 1, j, word, dict, prefix);
			grid[i][j] = c;
		}
		
		//bottom-left
		if (i + 1 < grid.length && j - 1 >= 0 && grid[i + 1][j - 1] != '.' && prefix.contains(word + grid[i + 1][j - 1])) {
			grid[i][j] = '.';
			helper(res, grid, i + 1, j - 1, word, dict, prefix);
			grid[i][j] = c;
		}
		
		//left
		if (j - 1 >= 0 && grid[i][j - 1] != '.' && prefix.contains(word + grid[i][j - 1])) {
			grid[i][j] = '.';
			helper(res, grid, i, j - 1, word, dict, prefix);
			grid[i][j] = c;
		}
		
	}
	
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
		char[][] grid = new char[][]{{'a', 'b', 'c', 'd', 'e'}, {'f', 'g', 'h', 'i', 'j'}, {'k', 'l', 'm', 'n', 'o'}, {'p', 'q', 'r', 's', 't'}, {'u', 'v', 'w', 'x', 'y'}};
		long startTime = System.currentTimeMillis();
		HashSet<String> dict = new HashSet<String>();
		HashSet<String> prefix = new HashSet<String>();
		BufferedReader br = new BufferedReader(new FileReader("/Users/gaohong/Documents/workspace/Sorting/scowl-7.1/final/english-words.95"));
		String line;
		while ((line = br.readLine()) != null) {
			String word = line.trim();
			dict.add(word);
			for (int i = 1; i <= word.length(); i++) {
				prefix.add(word.substring(0, i));
			}
		}
		br.close();
		List<String> res = solve(grid, dict, prefix);
		System.out.println(res.toString());
		long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime));
	}
}
