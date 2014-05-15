public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int temp = matrix[first][i]; //save top
                matrix[first][i] = matrix[last - i + first][first]; //left -> top;
                matrix[last - i + first][first] = matrix[last][last - i + first]; //bottom -> left;
                matrix[last][last - i + first] = matrix[i][last]; // right -> bottom
                matrix[i][last] = temp; //top(temp) -> right;
            }
        }
    }
}

//layer by layer, from outer to inner
//be careful with matrix index calculation
